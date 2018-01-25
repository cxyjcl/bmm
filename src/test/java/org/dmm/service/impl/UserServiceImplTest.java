package org.dmm.service.impl;

import org.dmm.constants.DataStatusEnum;
import org.dmm.entity.PageEntity;
import org.dmm.entity.User;
import org.dmm.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by pohoulong on 2018/1/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService service;

    @Test
    @Ignore
    public void insert() throws Exception {
        service.insert(new User("test", "test"));
    }

    @Test
    public void insertBatch() throws Exception {

    }

    @Test
    public void selectById() throws Exception {

    }

    @Test
    public void selectAll() throws Exception {
        PageEntity entity = new PageEntity();
        entity.setPageIndex(0);
        service.findAllUser(entity);
    }

    @Test
    public void deleteById() throws Exception {

    }

    @Test
    public void update() throws Exception {
        service.update(new User(1));
    }

    @Test
    public void find() throws Exception {

    }

    @Test
    @Ignore
    public void confirm() throws Exception {
        User user = new User("admin", "admin");
        service.confirm(user);
    }

}