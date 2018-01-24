package org.dmm.test;

import org.dmm.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

    @Autowired
    UserDao dao;

    @Test
    public void contextLoads() {
        System.out.println(dao.findByLoginNameAndPassword("admin", "admin"));
    }

}
