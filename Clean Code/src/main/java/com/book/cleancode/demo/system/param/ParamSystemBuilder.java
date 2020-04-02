package com.book.cleancode.demo.system.param;

public class ParamSystemBuilder {
    private static String IN_USE_Of_FORMAT = "l,p#,d*";

    public ParamSystem build(){
        ParamSystem paramSystem = new ParamSystem(IN_USE_Of_FORMAT);
        paramSystem.initParserHolder(IN_USE_Of_FORMAT);
        return paramSystem;
    }

    public static void setFormat(String format) {
        IN_USE_Of_FORMAT = format;
    }
}
