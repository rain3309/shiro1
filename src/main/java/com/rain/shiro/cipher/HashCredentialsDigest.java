package com.rain.shiro.cipher;

import org.apache.commons.lang3.StringUtils;

public abstract class HashCredentialsDigest implements CredentialsDigest{

    public static final int HASH_INTERATIONS = 1024;

    @Override
    public String digest(String plainCredentials, byte[] salt) {
        if(StringUtils.isBlank(plainCredentials)){
            return null;
        }
        byte[] hashPassword = digest(Cryptos.utf8encode(plainCredentials), salt);
        return Encodes.encodeHex(hashPassword);
    }

    @Override
    public boolean matches(String credentials, String plainCredentials, byte[] salt) {
        if(StringUtils.isBlank(credentials) && StringUtils.isBlank(plainCredentials)){
            return true;
        }
        return StringUtils.equals(credentials,digest(plainCredentials,salt));
    }

    protected abstract byte [] digest(byte[] input,byte[] salt);
}
