package com.book.cleancode.demo.system.param;

public class IntegerParamParser extends ParamParser {

    @Override
    public Integer createParam(ParamDefinition paramDefinition) {
        try {
            return Integer.valueOf(paramDefinition.getStringValue());
        } catch (Exception e) {
            return null;
        }

    }


}
