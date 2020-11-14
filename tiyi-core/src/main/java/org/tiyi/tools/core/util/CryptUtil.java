package org.tiyi.tools.core.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;

/**
 * Author: Brock-Tiyi
 * Date: 2020/11/14 18:46
 * Description: 数据加密 Data Encrypting
 * Version: 1.0
 * Knowledge has no limit
 */
public class CryptUtil {
    /**
     * Author : Brock-Tiyi
     * Date : 2020/11/14 19:30
     * ClassName CryptUtil
     * Description :aes加密
     * @param str
     * @param key  密钥16位
     * @Return : java.lang.String
    */
    public static String  encryptAES(String str, String key){
        //构建
        AES aes = SecureUtil.aes(key.getBytes());
        //加密为16进制表示
        String encryptHex = aes.encryptHex(str);
        return encryptHex;
    }
    public static String decryptAES(String encryptHex, String key){
        //构建
        AES aes = SecureUtil.aes(key.getBytes());
        //解密为原字符串
        String decryptStr = aes.decryptStr(encryptHex);
        return decryptStr;
    }

    public static String  encryptDES(String str, String key){
        //构建
        DES des = SecureUtil.des(key.getBytes());
        //加密为16进制表示
        String encryptHex = des.encryptHex(str);
        return encryptHex;
    }
    public static String decryptDES(String encryptHex, String key){
        //构建
        DES des = SecureUtil.des(key.getBytes());
        //解密为原字符串
        String decryptStr = des.decryptStr(encryptHex);
        return decryptStr;
    }

    public static void main(String[] args) {
        String key = "1234567891012345";
        String passwd = encryptAES("testt4444",key);
        System.out.println(passwd);
        System.out.println(decryptAES(passwd,key));

        String passwd1 = encryptDES("testt4444",key);
        System.out.println(passwd1);
        System.out.println(decryptDES(passwd1,key));
    }
}
