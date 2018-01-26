package org.dmm.vo;

import org.dmm.entity.Experience;
import org.dmm.entity.Job;
import org.dmm.entity.Train;
import org.dmm.entity.UserInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/26 0026.
 */
public class RegisterAddVo {

    private UserInfo info;

    private ArrayList<Experience> experienceList;

    private ArrayList<Train> trainList;

    private ArrayList<Job> jobList;

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    public ArrayList<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(ArrayList<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public ArrayList<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(ArrayList<Train> trainList) {
        this.trainList = trainList;
    }

    public ArrayList<Job> getJobList() {
        return jobList;
    }

    public void setJobList(ArrayList<Job> jobList) {
        this.jobList = jobList;
    }

    @Override
    public String toString() {
        return "RegisterAddVo{" +
                "info=" + info +
                ", experienceList=" + experienceList +
                ", trainList=" + trainList +
                ", jobList=" + jobList +
                '}';
    }
}
