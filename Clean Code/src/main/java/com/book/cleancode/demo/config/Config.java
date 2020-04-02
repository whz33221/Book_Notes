package com.book.cleancode.demo.config;

import com.book.cleancode.demo.pojo.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class Config {
    @Bean
    public Person demoPerson(){
       log.info("成功导入demoPerson");
       return new Person().setAge(19).setName("Joinson");
    }
}
