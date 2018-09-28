package com.example.springboot.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCupSize {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${content}")
    private String content;


    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say(){
        return cupSize;
    }

    @RequestMapping(value = "/content",method = RequestMethod.GET)
    public String content(){
        return content;
    }
}
