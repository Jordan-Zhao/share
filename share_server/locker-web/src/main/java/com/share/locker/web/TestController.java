package com.share.locker.web;

import javax.xml.registry.infomodel.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
      
    @RequestMapping("/showUserInfo")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("index");   
        /*User user = userService.selectUserById(1);  
        mav.addObject("user", user);   */
        return mav;    
    } 
}
