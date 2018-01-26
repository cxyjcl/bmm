package org.dmm.dao;

import org.dmm.entity.RegisterInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
public interface RegisterInfoDao extends JpaRepository<RegisterInfo, Integer> {
    Page<RegisterInfo> findAllByCreator(Pageable pageable, Integer creator);

    Page<RegisterInfo> findAllByRealName(Pageable pageable, String realName);
}
