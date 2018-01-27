package org.dmm.dao;

import org.dmm.entity.Train;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
public interface TrainDao extends JpaRepository<Train, Integer> {

    ArrayList<Train> findAllByRegisterInfoId(Integer registerInfoId);
    @Transactional
    void deleteByRegisterInfoId(Integer registerInfoId);
}
