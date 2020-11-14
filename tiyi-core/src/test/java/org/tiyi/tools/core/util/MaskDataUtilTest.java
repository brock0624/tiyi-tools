package org.tiyi.tools.core.util;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Brock-Tiyi
 * Date: 2020/11/14 10:19
 * Description:
 * Version: 1.0
 * Knowledge has no limit
 */
class MaskDataUtilTest {

    @org.junit.jupiter.api.Test
    void maskData() {
        assertEquals("120115********0712", MaskDataUtil.maskData("120115201406180712", 6, 4));
        assertEquals("955882*********3888", MaskDataUtil.maskData("9558820200019833888", 6, 4));
        assertEquals("188******38", MaskDataUtil.maskData("18810754438", 3, 2));
    }

}