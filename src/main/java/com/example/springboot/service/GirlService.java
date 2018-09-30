package com.example.springboot.service;


import com.example.springboot.ResultEnum;
import com.example.springboot.exception.GirlException;
import com.example.springboot.repository.GirlRepository;
import com.example.springboot.domain.Girl;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class GirlService {
    @Autowired
    public GirlRepository girlRepository;

    public void insertA(Girl A){
        girlRepository.save(A);
    }

    public void insertB(Girl B){
        girlRepository.save(B);
    }

    @Transactional
    public void insertAB(Girl girlA,Girl girlB) {
        girlRepository.save(girlA);
//        int a = 10/0;
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id);
        int age = girl.getAge();
        if (age < 10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age  >= 10 && age < 16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOLE);
        }else {
            throw  new GirlException(ResultEnum.ERROR);
        }
    }
}
