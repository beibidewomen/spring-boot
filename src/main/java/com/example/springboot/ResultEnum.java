package com.example.springboot;

public enum ResultEnum {
    ERROR(400,"error"),
    SUCCESS(200,"success"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOLE(101,"你应该在上初中")
    ;
    private Integer code;
    private String message;



    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
