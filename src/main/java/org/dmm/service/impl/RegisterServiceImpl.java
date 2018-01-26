package org.dmm.service.impl;

import org.dmm.dao.*;
import org.dmm.entity.*;
import org.dmm.exception.ConnectionRefusedException;
import org.dmm.service.RegisterService;
import org.dmm.vo.RegisterAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterInfoDao dao;
    @Autowired
    ExperienceDao experienceDao;
    @Autowired
    JobDao jobDao;
    @Autowired
    TrainDao trainDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    UserDao userDao;

    @Override
    public Integer insertInfo(Integer id) throws ConnectionRefusedException {
        RegisterInfo entity = new RegisterInfo();
        User user = userDao.findOne(id);
        entity.setRealName(user.getRealName());
        entity.setCreator(id);
        entity = dao.save(entity);
        Integer registerId = entity.getId();
        return registerId;
    }

    @Override
    public void insert(RegisterInfo entity) throws ConnectionRefusedException {

    }

    @Override
    public void insertBatch(List<RegisterInfo> entityList) throws ConnectionRefusedException {

    }

    @Override
    public RegisterInfo selectById(Integer id, String dataStatus) throws ConnectionRefusedException {
        return null;
    }

    @Override
    public List<RegisterInfo> selectAll(String dataStatus) throws ConnectionRefusedException {
        return null;
    }

    @Override
    public int deleteById(Integer id, Object userId) throws ConnectionRefusedException {
        return 0;
    }

    @Override
    public int update(RegisterInfo entity) throws ConnectionRefusedException {
        return 0;
    }

    @Override
    public RegisterInfo find(Object str) throws ConnectionRefusedException {
        return null;
    }

    @Override
    public Page<RegisterInfo> findAllInfo(PageEntity pageEntity) {
        Integer index = pageEntity.getPageIndex();
        Integer size = pageEntity.getPageSize();
        Pageable pageable = new PageRequest(index, size);
        return dao.findAll(pageable);
    }

    @Override
    public Page<RegisterInfo> findAllByUserId(RegisterInfo info) {
        Integer index = info.getPageIndex();
        Integer size = info.getPageSize();
        Pageable pageable = new PageRequest(index, size);
        return dao.findAllByCreator(pageable,info.getCreator());
    }

    @Override
    public Page<RegisterInfo> selectByRealName(String realName, PageEntity page) {
        Integer index = page.getPageIndex();
        Integer size = page.getPageSize();
        Pageable pageable = new PageRequest(index, size);
        return dao.findAllByRealName(pageable,realName);
    }

    @Override
    public void insertAllRegister(RegisterAddVo vo) {
        userInfoDao.save(vo.getInfo());
        experienceDao.save(vo.getExperienceList());
        jobDao.save(vo.getJobList());
        trainDao.save(vo.getTrainList());
    }

    @Override
    public RegisterAddVo selectAllRegister(Integer registerId) {
        RegisterAddVo vo = new RegisterAddVo();
        UserInfo info = userInfoDao.findAllByRegisterInfoId(registerId);
        ArrayList<Experience> experienceList = experienceDao.findAllByRegisterInfoId(registerId);
        ArrayList<Job> jobList = jobDao.findAllByRegisterInfoId(registerId);
        ArrayList<Train> trainList = trainDao.findAllByRegisterInfoId(registerId);
        vo.setInfo(info);
        vo.setExperienceList(experienceList);
        vo.setJobList(jobList);
        vo.setTrainList(trainList);
        return vo;
    }
}
