package com.board.app.domain;

public class XSSConverter {
    public static String cleanXSS(String value) {
//        System.out.println("XSS Filter before : " + value);
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
//        System.out.println("XSS Filter after : " + value);
        return value;
    }
}
