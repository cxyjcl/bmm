package org.dmm.service;

import org.dmm.entity.PageEntity;
import org.dmm.entity.RegisterInfo;
import org.dmm.exception.ConnectionRefusedException;
import org.dmm.vo.RegisterAddVo;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
public interface RegisterService extends BaseService<RegisterInfo>{

    public Integer insertInfo(Integer id) throws ConnectionRefusedException;

    Page<RegisterInfo> findAllInfo(PageEntity pageEntity);

    Page<RegisterInfo> findAllByUserId(RegisterInfo info);

    Page<RegisterInfo> selectByRealName(String realName, PageEntity page);

    void insertAllRegister(RegisterAddVo vo);

    RegisterAddVo selectAllRegister(Integer id);
}
