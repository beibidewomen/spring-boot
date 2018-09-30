package com.example.springboot.controller;

import com.example.springboot.domain.Girl;
import com.example.springboot.repository.GirlRepository;
import com.example.springboot.service.GirlService;
import com.example.springboot.until.ResultUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class GirlController {

    @Autowired
    public GirlRepository girlRepository;

    @Autowired
    public GirlService girlService;


    @RequestMapping(value = "/girls",method = RequestMethod.GET)
    public List<Girl> girls(){
        return girlRepository.findAll();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addGirl(Girl girl){
        System.out.println("*************************");
        girl.setId(1);
        System.out.println(girl);

        System.out.println("*************************");
        girlRepository.save(girl);

    }

    @RequestMapping(value = "/find/{age}",method = RequestMethod.GET)
    public List<Girl> findByAgeList(@PathVariable int age){
        return girlRepository.findByAge(age);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public void insertData(){
        Girl girlA = new Girl();
        girlA.setId(2);
        girlA.setAge(22);
        girlA.setName("xiaoxiannv");
        girlA.setSex("female");


        Girl girlB = new Girl();
        girlB.setId(3);
        girlB.setAge(22);
        girlB.setName("xuzhiwen");
        girlB.setSex("female");
        girlService.insertAB(girlA,girlB);
    }

    @RequestMapping(value = "/validate",method = RequestMethod.POST)
    public Girl validateGirl(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setId(4);
        girlRepository.save(girl);
        return girl;
    }

    @RequestMapping(value = "/addData",method = RequestMethod.POST)
    public ResultUntil addData(@Valid Girl girl,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            ResultUntil resultUntil = new ResultUntil();
            resultUntil.setCode(1);
            resultUntil.setMessage(bindingResult.getFieldError().getDefaultMessage());
            resultUntil.setData(null);
            return resultUntil;
        }

        ResultUntil resultUntil = new ResultUntil();
        resultUntil.setCode(0);
        resultUntil.setMessage("成功");
        resultUntil.setData(girl);
        girlRepository.save(girl);
        return resultUntil;
    }

    @RequestMapping(value = "/getAge/{id}",method = RequestMethod.GET)
    public void getAge(@PathVariable int id) throws Exception{
        girlService.getAge(id);
    }

}
