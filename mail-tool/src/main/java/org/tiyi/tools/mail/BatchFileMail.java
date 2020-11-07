package org.tiyi.tools.mail;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.PrintStream;

/**
 * Author: Brock-Tiyi
 * Date: 2020/11/1 18:10
 * Description:
 * Version: 1.0
 * Knowledge has no limit
 */
public class BatchFileMail {

    public static PrintStream out;
    public static PrintStream err;

    public MailAccount createMailAccount(String host, String user, String pass) {
        MailAccount account = new MailAccount();
        account.setHost(host);
        account.setPort(25);
        account.setAuth(true);
        account.setFrom(user);
        account.setUser(user);
        account.setPass(pass);
        return account;
    }

    public void sendBatchFileMail(MailAccount account,  String mailto, String mailsubject, String mailcontent,String filepath) {
        File[] files = FileUtil.ls(filepath);
        Integer filesize = files.length;
        System.out.println("总共有" + filesize + "个文件!");
        for (int i=0;i<filesize;i++) {
            if (files[i].isFile())
                System.out.println("准备发送第"+i+"个文件，文件名：" + files[i].toString());
            mailsubject = mailsubject+"-"+files[i].getName();
            MailUtil.send(account, mailto, mailsubject, mailcontent, false, files[i]);
            System.out.println("第"+i+"个文件发送成功，文件名：" + files[i].toString());
        }

    }

    public static void gnuParseCLI(String[] args) {
        BatchFileMail batchmail = new BatchFileMail();
        Options options = new Options();
        options.addOption("h", "help", false, "print options' information");
        options.addOption("H", "host", true, "mail.smtp.host");
        options.addOption("u", "user", true, "mail.smtp.user,xxx@xx.com");
        options.addOption("p", "pass", true, "mail.smtp.pass");
        options.addOption("t", "tos", true, "mail to");
        options.addOption("s", "subject", true, "mail subject");
        options.addOption("c", "content", true, "mail content");
        options.addOption("f", "filepath", true, "mail filepath");
        options.addOption("send", false, "mail send");


        CommandLineParser parser = new PosixParser();
        try {
            CommandLine cli = parser.parse(options, args);
            if (cli.hasOption("h")) {
                HelpFormatter hf = new HelpFormatter();
                hf.printHelp("Options", options);
            } else if (cli.hasOption("send")) {
                String host = cli.getOptionValue("H");
                System.out.println("host: " + host);
                String user = cli.getOptionValue("u");
                System.out.println("user: " + user);
                String pass = cli.getOptionValue("p");
                String tos = cli.getOptionValue("t");
                System.out.println("tos: " + tos);
                String subject = cli.getOptionValue("a");
                System.out.println("subject: " + subject);
                String content = cli.getOptionValue("c");
                System.out.println("content: " + content);
                String filepath = cli.getOptionValue("f");
                System.out.println("filepath: " + filepath);
                String send = cli.getOptionValue("send");
                System.out.println("send: " + send);
                MailAccount account = batchmail.createMailAccount(host, user, pass);
                batchmail.sendBatchFileMail(account, tos, subject, content, filepath);

            } else {
                String host = cli.getOptionValue("H");
                System.out.println("host: " + host);
                String user = cli.getOptionValue("u");
                System.out.println("user: " + user);
                String pass = cli.getOptionValue("p");
                String tos = cli.getOptionValue("t");
                System.out.println("tos: " + tos);
                String subject = cli.getOptionValue("a");
                System.out.println("subject: " + subject);
                String content = cli.getOptionValue("c");
                System.out.println("content: " + content);
                String filepath = cli.getOptionValue("f");
                System.out.println("filepath: " + filepath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BatchFileMail batchmail = new BatchFileMail();
        Options options = new Options();
        options.addOption("h", "help", false, "print options' information");
        options.addOption("H", "host", true, "mail.smtp.host");
        options.addOption("u", "user", true, "mail.smtp.user,xxx@xx.com");
        options.addOption("p", "pass", true, "mail.smtp.pass");
        options.addOption("t", "tos", true, "mail to");
        options.addOption("s", "subject", true, "mail subject");
        options.addOption("c", "content", true, "mail content");
        options.addOption("f", "filepath", true, "mail filepath");
        options.addOption("send", false, "mail send");


        CommandLineParser parser = new PosixParser();
        try {
            CommandLine cli = parser.parse(options, args);
            if (cli.hasOption("h")) {
                HelpFormatter hf = new HelpFormatter();
                hf.printHelp("Options", options);
            } else if (cli.hasOption("send")) {
                String host = cli.getOptionValue("H");
                System.out.println("host: " + host);
                String user = cli.getOptionValue("u");
                System.out.println("user: " + user);
                String pass = cli.getOptionValue("p");
                String tos = cli.getOptionValue("t");
                System.out.println("tos: " + tos);
                String subject = cli.getOptionValue("s");
                System.out.println("subject: " + subject);
                String content = cli.getOptionValue("c");
                System.out.println("content: " + content);
                String filepath = cli.getOptionValue("f");
                System.out.println("filepath: " + filepath);
                String send = cli.getOptionValue("send");
                System.out.println("send: " + send);
                MailAccount account = batchmail.createMailAccount(host, user, pass);
                batchmail.sendBatchFileMail(account, tos, subject, content, filepath);

            } else {
                String host = cli.getOptionValue("H");
                System.out.println("host: " + host);
                String user = cli.getOptionValue("u");
                System.out.println("user: " + user);
                String pass = cli.getOptionValue("p");
                String tos = cli.getOptionValue("t");
                System.out.println("tos: " + tos);
                String subject = cli.getOptionValue("s");
                System.out.println("subject: " + subject);
                String content = cli.getOptionValue("c");
                System.out.println("content: " + content);
                String filepath = cli.getOptionValue("f");
                System.out.println("filepath: " + filepath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
