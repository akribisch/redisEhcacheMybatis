package com.web.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
@SuppressWarnings("serial")
public class Student implements Serializable{

    private int stuNo;//编号

    private String stuName; //姓名

    private int stuSex;//性别 0：男  1：女

    private int stuAge;//年龄


    public Student(int stuNo, String stuName, int stuSex, int stuAge) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
    }

    public Student() {
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuSex() {

        return stuSex;
    }

    public void setStuSex(int stuSex) {
        this.stuSex = stuSex;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }
}
