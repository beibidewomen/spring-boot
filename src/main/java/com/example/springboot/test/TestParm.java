package com.example.springboot.test;

import com.example.springboot.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestParm {
    @Autowired
    public GirlProperties girlProperties;


    @RequestMapping(value = "/parm/{id}",method = RequestMethod.GET)
    public String parm(@PathVariable("id") String id){
        return id;
    }

    @RequestMapping(value = "/requestParm",method = RequestMethod.GET)
    public String requestParm(@RequestParam("id") String id){
        return id;
    }

    @RequestMapping(value = "/requestParmD",method = RequestMethod.GET)
    public String requestParmD(@RequestParam(value = "id",required = false,defaultValue="0") String id){
        return id;
    }

    @RequestMapping(value = "/properties",method = RequestMethod.GET)
    public String properties(){
        return girlProperties.getSex();
    }
}
