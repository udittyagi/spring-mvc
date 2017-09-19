package com.udit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by udit on 19/9/17.
 */

@Controller
public class IndexController {

    //@RequestMapping will map the incoming request to this method of "/" uri
    @RequestMapping("/")
    public String index(){
        //we return the view name so that view resolver can resolve the view
        return "index";
    }
}
