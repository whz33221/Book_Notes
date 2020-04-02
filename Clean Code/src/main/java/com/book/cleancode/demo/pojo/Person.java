package com.book.cleancode.demo.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Person {
    public int age;
    public String name;
}
