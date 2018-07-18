package com.nyist.controller;

import com.nyist.pojo.TUser;
import com.nyist.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/7/16/016.
 */
@Controller
@RequestMapping("/tUser")
public class TUserController {
    @Autowired
    private TUserService tUserService;
    @RequestMapping("/count")
    public Long getCount(){
        TUser tUser= (TUser) tUserService.getUser("2").getData();
        Long count = null;
        return count;
    }
}
