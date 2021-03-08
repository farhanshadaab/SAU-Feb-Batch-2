package com.au.spring;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;

@Component
public class teacher {
	String name = "abc";
    int id = 123;


public void getName() {
        System.out.println("abc");
    }

    public int getId()
    {
        return id;
    }

    public void getCourse(String course)throws  Exception {

        System.out.println("Course = " + course);
        throw new RuntimeException();

    }
}
