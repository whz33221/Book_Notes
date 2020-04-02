package com.book.cleancode.demo.system.param;

public class BooleanParamParser extends ParamParser {
    @Override
    public Object createParam(ParamDefinition paramDefinition) {
        try {
            return Boolean.valueOf(paramDefinition.getStringValue());
        } catch (Exception e) {
            return null;
        }
    }
}
