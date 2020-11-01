package org.tiyi.tools.mail;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailUtil;

/**
 * Author: Brock-Tiyi
 * Date: 2020/11/1 17:56
 * Description:
 * Version: 1.0
 * Knowledge has no limit
 */
public class Main {
    public static void main(String[] args) {

        MailUtil.send("haoyuganghyg@163.com", "测试", "邮件来自Hutool测试", false, FileUtil.file("D:\\tmp\\abx.txt"));
    }
}
