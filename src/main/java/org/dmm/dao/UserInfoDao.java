package org.dmm.dao;

import org.dmm.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
    UserInfo findAllByRegisterInfoId(Integer registerInfoId);
    @Transactional
    void deleteByRegisterInfoId(Integer registerInfoId);
}
