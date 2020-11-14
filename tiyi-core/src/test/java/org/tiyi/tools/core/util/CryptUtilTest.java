package org.tiyi.tools.core.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: Brock-Tiyi
 * Date: 2020/11/14 19:35
 * Description:
 * Version: 1.0
 * Knowledge has no limit
 */
class CryptUtilTest {
    String pass = "testt4444";
    String key = "1234567891012345";
    String aespass = "d286d93f569991c3627c67dff23fd8d2";
    String despass = "c8e7a447993f376812734f9518ee324a";

    @Test
    void encryptAES() {
        String passwd = CryptUtil.encryptAES(pass,key);
        assertEquals(passwd,aespass);
    }

    @Test
    void decryptAES() {
        String passwd = CryptUtil.decryptAES(aespass,key);
        assertEquals(pass,passwd);
    }

    @Test
    void encryptDES() {
        String passwd = CryptUtil.encryptDES(pass,key);
        assertEquals(passwd,despass);
    }

    @Test
    void decryptDES() {
        String passwd = CryptUtil.decryptDES(despass,key);
        assertEquals(pass,passwd);
    }
}