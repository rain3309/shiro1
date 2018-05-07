package com.rain.shiro.cipher;

import org.apache.commons.codec.binary.Hex;

public class Encodes {

    public static String encodeHex(byte[] input){
        return Hex.encodeHexString(input);
    }
}
