package com.rest.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtil {
    public static String makeHash(String password){

        String passwordEncripted = DigestUtils.sha256Hex(password);
        return passwordEncripted;
    }

}
