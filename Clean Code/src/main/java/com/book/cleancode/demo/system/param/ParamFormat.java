package com.book.cleancode.demo.system.param;

public abstract class ParamFormat<T> {

    private ParamFormat(){

    }

    public static ParamParser getParamParser(String format) {
        String parserCode = format.substring(1);
        if ("#".equals(parserCode)) {
            return new IntegerParamParser();
        } else if ("*".equals(parserCode)) {
            return new StringParamParser();
        } else if ("".equals(parserCode)) {
            return new BooleanParamParser();
        }else{
            throw new IllegalArgumentException();
        }
    }


    public static Character getParamType(String format) {
        if(format.length()<1){
            throw new IllegalArgumentException();
        }
        Character paramType = format.charAt(0);
        return paramType;
    }
}
