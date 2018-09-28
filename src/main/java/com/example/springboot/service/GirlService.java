package com.example.springboot.service;


import com.example.springboot.repository.GirlRepository;
import com.example.springboot.domain.Girl;
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
}
