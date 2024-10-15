package com.example.demo;


import com.example.demo.demos.web.People;
import org.springframework.stereotype.Component;

@Component
public class B implements People {


    @Override
    public void test() {
        System.out.println(123);
    }
}
