package org.dmm.service.impl;

import org.dmm.constants.CommonStatusEnum;
import org.dmm.dao.UserDao;
import org.dmm.entity.*;
import org.dmm.exception.ConnectionRefusedException;
import org.dmm.exception.LoginNameRepeatException;
import org.dmm.exception.NoDataException;
import org.dmm.exception.PasswordException;
import org.dmm.service.UserService;
import org.dmm.utils.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pohoulong on 2018/1/15.
 */
@Service
public class UserServiceImpl implements UserService {

    private String salt = "dsafsfsgjdkgbcbzklhgelg";

    @Autowired
    private UserDao dao;


    @Override
    public Integer confirm(User user) throws PasswordException {
        String password = user.getPassword();
        String loginName = user.getLoginName();
        password = MD5Util.encode(password + salt);
        User findUser = dao.findByLoginNameAndPassword(loginName, password);
        if (findUser == null) {
            throw new PasswordException(CommonStatusEnum._PASSWORD_ERROR.getCode(),
                    CommonStatusEnum._PASSWORD_ERROR.getContent());
        }
        Integer id = findUser.getId();
        return id;
    }

    @Override
    public void findByLoginName(String loginName) throws LoginNameRepeatException {
        User findUser = dao.findByLoginName(loginName);
        if (findUser != null) {
            throw new LoginNameRepeatException(CommonStatusEnum._REPEAT_LOGINNAME.getCode(), CommonStatusEnum._REPEAT_LOGINNAME.getContent());
        }
    }

    @Override
    public Page<User> findAllUser(PageEntity page) throws NoDataException {
        Integer index = page.getPageIndex();
        Integer size = page.getPageSize();
        Pageable pageable = new PageRequest(index, size);
        return dao.findAll(pageable);
    }

    @Override
    public Page<User> selectByRealName(String realName, PageEntity page) {
        Integer index = page.getPageIndex();
        Integer size = page.getPageSize();
        Pageable pageable = new PageRequest(index, size);
        return dao.findByRealName(realName,pageable);
    }

    @Override
    public void insert(User entity) throws ConnectionRefusedException {
        String password = entity.getPassword();
        password = MD5Util.encode(password + salt);
        entity.setPassword(password);
        dao.save(entity);
    }

    @Override
    public void insertBatch(List<User> entityList) throws ConnectionRefusedException {
        dao.save(entityList);
    }

    @Override
    public User selectById(Integer id, String dataStatus) throws ConnectionRefusedException {
        return dao.findOne(id);
    }

    @Override
    public List<User> selectAll(String dataStatus) throws ConnectionRefusedException {
        return null;
    }

    @Override
    public int deleteById(Integer id, Object userId) throws ConnectionRefusedException {
        return 0;
    }

    @Override
    public int update(User entity) throws ConnectionRefusedException {
        String password = entity.getPassword();
        if(!"".equals(password)){
            password = MD5Util.encode(password + salt);
            entity.setPassword(password);
            dao.save(entity);
        }
        return 1;
    }

    @Override
    public User find(Object str) throws ConnectionRefusedException {
        return null;
    }
}
