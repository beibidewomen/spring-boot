package com.example.springboot.handle;

import com.example.springboot.exception.GirlException;
import com.example.springboot.until.ResultUntil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultUntil handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            ResultUntil resultUntil = new ResultUntil();
            resultUntil.setCode(girlException.getCode());
            resultUntil.setMessage(e.getMessage());
            resultUntil.setData(null);
            return  resultUntil;
        }
        return null;
    }
}
