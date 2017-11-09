package com.example.administrator.smartbutler.entity;

import cn.bmob.v3.BmobUser;

/**
 * 项目名：  SmartButler
 * 包名：    com.example.administrator.smartbutler.entity
 * 文件名:   MyUser
 * 创建者:   LGL
 * 创建时间:  2017/11/5 22:44
 * 描述：    TODO
 */

public class MyUser extends BmobUser {
    private int age;
    private boolean sex;
    private String desc;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
