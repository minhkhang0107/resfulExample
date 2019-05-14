package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeModel {
    private int id;
    private String name;
    private String desc;
    private int age;
    private String address;
    private String sex;

    public EmployeModel(int id, String name, String desc, int age, String address, String sex) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.age = age;
        this.address = address;
        this.sex = sex;
    }

    public EmployeModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
