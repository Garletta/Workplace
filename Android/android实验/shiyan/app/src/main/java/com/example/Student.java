package com.example;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String height;
    private String weight;
    private String sex;
    private String hobby;
    private String profession;

    Student(String name, String height, String weight, String sex, String hobby, String profession){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.hobby = hobby;
        this.profession = profession;
    }
    Student(){
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getSex() {
        return sex;
    }

    public String getHobby() {
        return hobby;
    }

    public String getProfession() {
        return profession;
    }


    public String speak(){
        String info = "姓名："+name+'\n'
                +"身高："+height+'\n'
                +"体重："+weight+'\n'
                +"性别："+sex+'\n'
                +"爱好："+hobby+'\n'
                +"专业："+profession;
        return info;
    }

}
