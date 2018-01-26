package org.dmm.service.impl;

import org.dmm.entity.RegisterInfo;
import org.dmm.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterServiceImplTest {

    @Autowired
    RegisterService service;

    @Test
    public void findAllByUserId() throws Exception {
        RegisterInfo info = new RegisterInfo();
        info.setPageIndex(0);
        info.setCreator(1);
        System.out.println(service.findAllByUserId(info));
    }

}