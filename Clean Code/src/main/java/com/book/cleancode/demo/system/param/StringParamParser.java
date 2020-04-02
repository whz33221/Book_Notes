package com.book.cleancode.demo.system.param;

public class StringParamParser extends ParamParser {

    @Override
    public String createParam(ParamDefinition paramDefinition) {
        return paramDefinition.getStringValue();
    }
}
