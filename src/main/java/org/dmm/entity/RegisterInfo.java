package org.dmm.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/1/24 0024.
 */
@Entity
@DynamicUpdate(true)
public class RegisterInfo extends BaseEntity{

    @Id
    @GeneratedValue
    private Integer id;

    private String tablename;

    private Integer userInfoId;

    private Integer experienceId;

    private Integer trainId;

    private Integer jobId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Integer getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Integer experienceId) {
        this.experienceId = experienceId;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "RegisterInfo{" +
                "id=" + id +
                ", tablename='" + tablename + '\'' +
                ", userInfoId=" + userInfoId +
                ", experienceId=" + experienceId +
                ", trainId=" + trainId +
                ", jobId=" + jobId +
                '}';
    }
}
