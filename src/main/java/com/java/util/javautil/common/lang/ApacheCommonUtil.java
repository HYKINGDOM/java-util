package com.java.util.javautil.common.lang;

import org.apache.commons.lang3.StringUtils;

public class ApacheCommonUtil {

    public static void main(String[] args) {
        String str02 = new StringBuilder("测试").append("wenjian").toString();
        System.out.println(str02.intern() == str02);


        String str01 = new StringBuilder("ja").append("va").toString();
        System.out.println(str01.intern() == str01);
    }
}
