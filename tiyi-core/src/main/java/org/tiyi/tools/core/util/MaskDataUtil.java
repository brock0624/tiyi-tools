package org.tiyi.tools.core.util;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: Brock-Tiyi
 * Date: 2020/11/14 10:04
 * Description: 数据脱敏 Data Masking
 * Version: 1.0
 * Knowledge has no limit
 */
public class MaskDataUtil {
    public static String maskData(String str, int headCharCount, int tailCharCount) {
        if(str.length()<headCharCount+tailCharCount){
            throw new IllegalArgumentException("明文过短，无法脱敏");
        }
        String repeat = "";

        int len = str.length() - headCharCount - tailCharCount;
        if (len > 0) {
            char[] buf = new char[len];
            AtomicInteger integer = new AtomicInteger(0);
//            Arrays.asList(new Integer[len]).stream().forEach(b -> buf[integer.getAndIncrement()] = '*');
            Arrays.stream(new Integer[len]).forEach(b -> buf[integer.getAndIncrement()] = '*');
            repeat = new String(buf);
        }
        return str.substring(0, headCharCount) + repeat + str.substring(str.length() - tailCharCount);
    }

    public static void main(String[] args) {
        System.out.println(maskData("120115201406180712", 6, 4));
        System.out.println(maskData("9558820200019833888", 6, 4));
        System.out.println(maskData("18810754438", 3, 4));
    }
}
