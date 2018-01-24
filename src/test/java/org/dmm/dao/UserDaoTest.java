package org.dmm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.dmm.entity.User;

/**
 * Created by pohoulong on 2018/1/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    UserDao dao;

    @Test
    public void findByLoginNameAndPassword() throws Exception {
        System.out.println(dao.findByLoginNameAndPassword("admin", "admin"));
    }

    @Test
    public void save() {
        System.out.println(dao.save(new User("admin", "admin")));
    }

    @Test
    public void findByLoginName() {
        System.out.println(dao.findByLoginName("admin"));
    }

}