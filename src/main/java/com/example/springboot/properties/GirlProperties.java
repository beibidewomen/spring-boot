package com.example.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    public String sex;
    public int height;
    public int weight;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
