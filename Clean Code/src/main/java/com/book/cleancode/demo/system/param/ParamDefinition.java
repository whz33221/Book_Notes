package com.book.cleancode.demo.system.param;

public class ParamDefinition {
    private Character type;
    private String stringValue = "";
    private String arg="";
    private boolean argRegularly = false;


    public ParamDefinition(String arg) {
        checkArgRegulation(arg);
        if(argRegularly){
            parseArg();
        }
    }


    private void checkArgRegulation(String arg) {
        if(!arg.startsWith("-")){
            return;
        }
        String[] strs = arg.split(" ");
        if(strs.length<2){
            return;
        }
        if(strs[0].length()>2){
            return;
        }
        argRegularly = true;
        this.arg = arg;
    }

    private void parseArg() {
        parseArgType();
        parseArgStringValue();

    }

    private void parseArgType() {
        String[] s = arg.split(" ");
        type = s[0].substring(1).toCharArray()[0];
    }

    private void parseArgStringValue() {
        String[] s = arg.split(" ");
        for (int i = 1; i < s.length; i++) {
            stringValue += s[i];
        }
    }

    public Character getType() {
        return type;
    }

    public String getStringValue() {
        return stringValue;
    }

    public boolean isArgRegularly() {
        return argRegularly;
    }
}
