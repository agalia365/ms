package com.leo.weather.msweatherdata;

import java.io.UnsupportedEncodingException;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "�\u000E�xg�b�x�\u0013���";

       String s2 = new String(s.getBytes("ISO-8859-1"),"UTF-8") ;
        System.out.println(s2);
    }
}
