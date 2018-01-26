package org.dmm.dao;

import org.dmm.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
public interface ExperienceDao extends JpaRepository<Experience, Integer> {

    ArrayList<Experience> findAllByRegisterInfoId(Integer registerInfoId);
}
