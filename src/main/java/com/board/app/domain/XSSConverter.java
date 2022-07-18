package com.board.app.domain;

public class XSSConverter {
    public static String cleanXSS(String value) {
//        System.out.println("XSS Filter before : " + value);
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("'", "&#39;");
//        System.out.println("XSS Filter after : " + value);
        return value;
    }
}
