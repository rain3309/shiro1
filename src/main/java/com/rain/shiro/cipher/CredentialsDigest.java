package com.rain.shiro.cipher;

public interface CredentialsDigest {

    public String digest(String plainCredentials,byte[] salt);

    public boolean matches(String credentials,String plainCredentials,byte[] salt);
}
