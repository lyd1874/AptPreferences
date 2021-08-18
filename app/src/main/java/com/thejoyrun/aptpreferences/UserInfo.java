package com.thejoyrun.aptpreferences;

public class UserInfo {

    private String userName;

    private int age;

    public UserInfo(){}

    public UserInfo(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
