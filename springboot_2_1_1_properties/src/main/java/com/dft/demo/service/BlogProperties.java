package com.dft.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {

    @Value("${com.dft.blog.name}")
    private String name;
    @Value("${com.dft.blog.title}")
    private String title;
    @Value("${com.dft.blog.nickname}")
    private String nickname;

    @Value("${com.dft.blog.value}")
    private String value;
    @Value("${com.dft.blog.number}")
    private String number;
    @Value("${com.dft.blog.number2}")
    private String number2;
    @Value("${com.dft.blog.number3}")
    private String number3;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getNumber3() {
        return number3;
    }

    public void setNumber3(String number3) {
        this.number3 = number3;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
