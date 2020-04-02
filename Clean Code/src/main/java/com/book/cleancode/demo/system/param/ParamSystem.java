package com.book.cleancode.demo.system.param;

import java.util.*;

public class ParamSystem {

    //todo 究竟什么时候用静态变量，什么时候用实例变量呢？

    private  String FORMAT;
    private  Map<Character,ParamParser> paramParserHolder = new HashMap<>();
    private  List<ParamDefinition> paramDefinitions = new ArrayList<>();
    private  Map<Character,Object> paramHolder = new HashMap<>();






    protected  void initParserHolder(String formatStr) {
        String[] formats = formatStr.split(",");
        for (String format : formats) {
            Character paramName = ParamFormat.getParamType(format);
            ParamParser paramParser = ParamFormat.getParamParser(format);
            paramParserHolder.put(paramName,paramParser);
        }
    }



    protected ParamSystem(String format) {
        FORMAT = format;
    }

    /**
     * -l true,-p 12,-d helloworld
     * @param args
     */
    public void run(String[] args){
        parseToParamDefinition(args);
        HashMap<Character, Object> paramMap = createParamByParamDefinitions(args);
        loadParam(paramMap);
    }


    private void parseToParamDefinition(String[] args) {
        for (String arg : args) {
            ParamDefinition paramDefinition = new ParamDefinition(arg);
            paramDefinitions.add(paramDefinition);
        }
    }

    private HashMap<Character,Object> createParamByParamDefinitions(String[] args) {
        LinkedHashMap<Character, Object> paramMap = new LinkedHashMap<>();
        for (ParamDefinition paramDefinition : paramDefinitions) {
            if(paramDefinition.isArgRegularly()){
                ParamParser paramParser = paramParserHolder.get(paramDefinition.getType());
                Object paramValue = paramParser.createParam(paramDefinition);
                paramMap.put(paramDefinition.getType(),paramValue);
            }
        }
        return paramMap;
    }
    private void loadParam(HashMap<Character, Object> paramMap) {
        paramHolder.putAll(paramMap);
    }


    public  Map<Character, Object> getParamHolder() {
    return Collections.unmodifiableMap(paramHolder);

}
}
