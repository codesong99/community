package com.nowcoder.community;

import java.io.IOException;

/**
 * @author Song Weiwei
 * @date 2019-12-19
 * wkhtmltopdf测试类
 */
public class WKTests {

    public static void main(String[] args) {
        String cmd = "e:/wkhtmltopdf/bin/wkhtmltoimage --quality 75 https://www.nowcoder.com F:/javaproject/data/wk-images/2.png";
        try {
            Runtime.getRuntime().exec(cmd);
            System.out.println("ok.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
