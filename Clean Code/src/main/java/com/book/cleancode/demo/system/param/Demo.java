package com.book.cleancode.demo.system.param;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        ParamSystem paramSystem = new ParamSystemBuilder().build();
        paramSystem.run(new String[]{"-l true","-p 123123","-d helloWorld"});
        Map<Character, Object> paramHolder = paramSystem.getParamHolder();
        System.out.println(paramHolder);
    }
}
