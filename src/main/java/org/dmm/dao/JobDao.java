package org.dmm.dao;

import org.dmm.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
public interface JobDao extends JpaRepository<Job, Integer> {

    ArrayList<Job> findAllByRegisterInfoId(Integer registerInfoId);
}
