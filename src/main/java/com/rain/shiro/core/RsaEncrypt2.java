package com.rain.shiro.core;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RsaEncrypt2 {

    private static final String KEY_ALGORITHM = "RSA";
    private static final String PUBLICKEYSTR = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKvXxMJ9Zw5qvEjWnTjwt5RbFJWGTA7jSEUen3 j2RETTey1w0Cb5AsHGzxcvNEf9pSHG2WcBEY/JXPMBXgI/pnf/h6jl1tNdtBacN8US0Y7aK0/BNB avom9N8FRozfVuddqBLJR0THQevm6Cmo/Rb1Ih6iSSLNkJ+S5KeOSeNcIQIDAQAB";
    private static final String PRIVATEKEYSTR = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIq9fEwn1nDmq8SNadOPC3lFsUlY ZMDuNIRR6fePZERNN7LXDQJvkCwcbPFy80R/2lIcbZZwERj8lc8wFeAj+md/+HqOXW0120Fpw3xR LRjtorT8E0Fq+ib03wVGjN9W512oEslHRMdB6+boKaj9FvUiHqJJIs2Qn5Lkp45J41whAgMBAAEC gYBrRXcFqwey46eLoYtheAh3C9u3yhCc25DffjZYoxXzeYDHVl9IstnWQWQ6i5ZsMC6tri1NU/jk SOfL+nHvi+HfYJPD2XOTKrCHrfSYQl+s2rbFGgMNnRQ3V6CFK4w6LhLwXzjkoUxYnXca9fl8ancu u60dIVwnlyc/EgJ6nB2AAQJBAMk3/4ZhIYgMZwTc2yPxMZJE69Cbvqv7NZZ66EhAAWMlA8dW13t3 1meGuY00UiSaRaCWz24qBFN1INelTqbHjUECQQCwgwZSUJ9FB2y16jxXjPvWDa4/jZ7gIN7g+nrc bIZbe7XbB2xzM7YJmnwaG3sKBRYRwjjLUvN/iTtcTHiNFLbhAkA+k3CevMQtyBWdmIV59v9Airh/ RoAUgeoXYx+roGQODivPqT0YA5uk1GwN8rB8+5EdsOjPTLfNsIZHKfx8t2BBAkBp52MuljLJPugp yY1E1lDvICww826kePRgtchrYi3Gy9XTwYN/J0KMRoU5QM20uFKCey6KR43TMmpMOZGGzCvhAkBM lBRUPybh2rVuqg4RiCMi8NkbjkXvCGpMRTXwPYeKED4VIL5YlfuHk0NOTyuCUWzWYTvD6I8gAAbL EZt7Nfj4";
    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥数据字符串
     * @return RSAPublicKey 公钥
     */
    public static RSAPublicKey loadPublicKeyByStr(String publicKeyStr)throws Exception {
        try {
            byte[] buffer = Base64.decode(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        }
    }

    /**
     * 公钥加密过程
     *
     * @param publicKey 公钥
     *
     * @param plainTextData 明文数据
     * @return String 密文
     */
    public static String encrypt(RSAPublicKey publicKey, byte[] plainTextData)
            throws Exception {
        if (publicKey == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(plainTextData);
            return Base64.encode(output);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("加密公钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("明文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("明文数据已损坏");
        }
    }

    /**
     * 加密
     * @param plainTextData 需要加密的明文
     * @return 密文
     */
    public static String getEncryptStr(byte[] plainTextData)throws Exception{
        RSAPublicKey rsaPublicKey = loadPublicKeyByStr(PUBLICKEYSTR);
        String encrypt = encrypt(rsaPublicKey, plainTextData);
        return encrypt;
    }

    // 从字符串中加载私钥
    public static RSAPrivateKey loadPrivateKeyByStr(String privateKeyStr)
            throws Exception {
        try {
            byte[] buffer = Base64.decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("私钥非法");
        } catch (NullPointerException e) {
            throw new Exception("私钥数据为空");
        }
    }
    /**
     * 私钥解密过程
     *
     * @param privateKey
     *            私钥
     * @param cipherData
     *            密文数据
     * @return 明文
     */
    public static String decrypt(RSAPrivateKey privateKey, byte[] cipherData)
            throws Exception {
        if (privateKey == null) {
            throw new Exception("解密私钥为空, 请设置");
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] output = cipher.doFinal(cipherData);
            return new String(output);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("解密私钥非法,请检查");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("密文数据已损坏");
        }
    }

    /**
     * 解密
     * @param ciphertext 密文
     * @return 明文
     */
    public static String getDecryptStr(byte[] ciphertext)throws Exception{
        RSAPrivateKey rsaPrivateKey = loadPrivateKeyByStr(PRIVATEKEYSTR);
        String encrypt = decrypt(rsaPrivateKey, Base64.decode(ciphertext));
        return encrypt;
    }
}
