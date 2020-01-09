package com.longyx.zuul.util;


import org.apache.axis.encoding.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

/**
 * 描述：3desc加解密工具类
 * @author Administrator
 */
public class ThreeDesUtil {

    /**
     * 定义 加密算法,可用 DES,DESede,Blowfish
     */
    private static final String ALGORIHM = "DESede";

    /**
     * 算法/模式/补码方式
     */
    private static final String ALGORITHM_DES = "DESede/CBC/PKCS5Padding";

    /**
     * 编码方式
     */
    private final static String ENCODING = "utf-8";

    /**
     * 向量
     */
    private final static String IV = "01234567";

    /**
     * 密匙
     */
    private final static String SECRET = "D34AE719CE3246E407294114";

    /**
     * 加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encrypt(String data) throws Exception {
        Key desKey;
        DESedeKeySpec spec = new DESedeKeySpec(SECRET.getBytes(ENCODING));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORIHM);
        desKey = keyFactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
        IvParameterSpec ips = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, desKey, ips);
        byte[] encryptData = cipher.doFinal(data.getBytes());
        return Base64.encode(encryptData);
    }

    /**
     * 解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String decrypt(String data) throws Exception {
        Key desKey;
        DESedeKeySpec spec = new DESedeKeySpec(SECRET.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORIHM);
        desKey = keyFactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
        IvParameterSpec ips = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, desKey, ips);
        byte[] decryptData = cipher.doFinal(Base64.decode(data));
        return new String(decryptData, ENCODING);
    }

}
