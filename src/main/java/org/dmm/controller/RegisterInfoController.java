package org.dmm.controller;

import org.dmm.entity.PageEntity;
import org.dmm.entity.RegisterInfo;
import org.dmm.message.Message;
import org.dmm.service.RegisterService;
import org.dmm.vo.RegisterAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
@RestController
public class RegisterInfoController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register/all/get")
    public Message getAllRegister(@RequestBody PageEntity pageEntity) {
        Page<RegisterInfo> register = registerService.findAllInfo(pageEntity);
        return Message.success(register);
    }

    @PostMapping("/register/creator/get")
    public Message getRegisterByUserId(@RequestBody RegisterInfo info,HttpSession session) {
        Integer id = Integer.parseInt(session.getAttribute("userId").toString());
        info.setCreator(id);
        Page<RegisterInfo> register = registerService.findAllByUserId(info);
        return Message.success(register);
    }


    @PostMapping("/register/find")
    public Message selectByTableName(@RequestBody RegisterInfo register){
        String realName = register.getRealName();
        Integer pageIndex = register.getPageIndex();
        PageEntity page =new PageEntity();
        page.setPageIndex(pageIndex);
        Page<RegisterInfo> userList  = registerService.selectByRealName(realName,page);
        return Message.success(userList);
    }

    @PostMapping("/register/update")
    public Message update(@RequestBody RegisterInfo register){
        registerService.update(register);
        return Message.success();
    }

    @PostMapping("/all/register/add")
    public Message addAllRegister(@RequestBody RegisterAddVo vo){
        registerService.insertAllRegister(vo);
        return Message.success();
    }

    @PostMapping("/all/register/get")
    public Message getAllRegister(HttpSession session){
        Integer id = Integer.parseInt(session.getAttribute("registerId").toString());
        RegisterAddVo vo = registerService.selectAllRegister(id);
        return Message.success(vo);
    }

    @PostMapping("/add/register")
    public Message addRegister(HttpSession session){
        Integer id = Integer.parseInt(session.getAttribute("userId").toString());
        registerService.insertInfo(id);
        session.setAttribute("registerId",id);
        return Message.success();
    }

    @PostMapping("/get/id/register")
    public Message getRegister(HttpSession session){
        Integer id = Integer.parseInt(session.getAttribute("registerId").toString());
        return Message.success(id);
    }

    @PostMapping("/update/{id}/register")
    public Message getRegister(@PathVariable("id") Integer id,HttpSession session){
        session.setAttribute("registerId",id);
        return Message.success();
    }
}
