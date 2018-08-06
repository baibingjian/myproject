package com.huawei.util;

import org.apache.tomcat.util.codec.binary.StringUtils;

/**
 * Created by machenike on 2018/7/18.
 */
public class Test {
    public static void main(String[] args) {
    String i = "sa";
    String i1 ="sa";
    String i2 = new String("sa");

        System.out.println(i == i1);
        System.out.println(i == i2);

        Integer i3 = 3;
        int i4 = 3;
        Integer i5 = null;
        Integer i6 = null;
        System.out.println(i3 == i4);
        System.out.println(i5 == i3);
        System.out.println(i3 == i5);
        System.out.println(i5 == i6);

    }
}
