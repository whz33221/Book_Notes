package com.book.cleancode.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaTestDrivenDemoApplication {

//    public static void main(String[] args) throws CloneNotSupportedException {
//        SpringApplication springApplication = new SpringApplication(CleanCodeDemoApplication.class);
        /**
        * 自定义加载SpringBean方式一：
        */
//        LinkedHashSet<String> sources = new LinkedHashSet<>();
//        sources.add("com.test.cleancode.Config");
//        springApplication.setSources(sources);
//
        /**
         * 自定义加载SpringBean方式二：
         */
//        ArrayList classes = new ArrayList<>();
//        classes.add(Config.class);
//        springApplication.addPrimarySources(classes);
//        springApplication.run(args);
//    }


    /**
     * SpringBoot启动方式一
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        SpringApplication springApplication = new SpringApplication(JavaTestDrivenDemoApplication.class);
        springApplication.run(args);
    }


/**
     * SpringBoot启动方式二
     * @param args
     * @throws CloneNotSupportedException
     */
//    public static void main(String[] args) throws CloneNotSupportedException {
//        SpringApplication.run(CleanCodeDemoApplication.class);
//    }


    /**
     * SpringBoot启动方式三
     * @param args
     * @throws CloneNotSupportedException
     */
//    public static void main(String[] args) throws CloneNotSupportedException {
//        SpringApplication springApplication =
//                new SpringApplicationBuilder(CleanCodeDemoApplication.class)
//                        .properties("server.port=7777")
//                        .build();
//
//        LinkedHashSet<String> sources = new LinkedHashSet<String>();
//        sources.add("com.test.cleancode.demo");
//        springApplication.setSources(sources);
//        springApplication.run(args);
//    }
}
