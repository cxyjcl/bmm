package org.dmm.service;

import org.dmm.entity.PageEntity;
import org.dmm.entity.User;
import org.dmm.exception.ConnectionRefusedException;
import org.dmm.exception.NoDataException;
import org.dmm.exception.PasswordException;
import org.dmm.exception.LoginNameRepeatException;
import org.springframework.data.domain.Page;

/**
 * Created by pohoulong on 2018/1/15.
 */
public interface UserService extends BaseService<User> {

    public Integer confirm(User user) throws PasswordException;

    public void findByLoginName(String username) throws LoginNameRepeatException;

    public Page<User> findAllUser(PageEntity pageEntity) throws NoDataException;

}
