package org.dmm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/24 0024.
 */
@Controller
public class BaseController {

    @GetMapping("view/login")
    public String login(){
        return "view/user/login";
    }

    @GetMapping("view/register")
    public String register(){
        return "view/user/register";
    }

    @GetMapping("view/manager")
    public String manager(){
        return "view/user/manager";
    }

    @GetMapping("view/change")
    public String change(){
        return "view/user/change";
    }

    @GetMapping("view/add")
    public String add(){
        return "view/register/add";
    }

    @GetMapping("view/list")
    public String list(){
        return "view/register/list";
    }

    @GetMapping("/view/error")
    public String error(){ return "view/500";}
}
