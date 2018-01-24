package org.dmm.dao;

import org.dmm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pohoulong on 2018/1/12.
 */

public interface UserDao extends JpaRepository<User, Integer> {


    User findByLoginNameAndPassword(String loginName, String Password);

    User findByLoginName(String loginName);

}
