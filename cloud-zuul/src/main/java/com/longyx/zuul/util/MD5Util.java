package com.longyx.zuul.util;

import org.springframework.util.DigestUtils;

/**
 * @author Administrator
 */
public class MD5Util{
    //盐，用于组合md5
    private static final String slat = "&%5123***&&%%$$#@";

    public static String getMD5(String str) {
        String base = str +"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}