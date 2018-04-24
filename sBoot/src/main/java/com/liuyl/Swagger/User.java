package com.liuyl.Swagger;

/**
 * Created by liuyanlei on 2018/4/23.
 */
public class User {

    private long id;
    private Object name;
    private int age;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public Object getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name=" + name +
            ", age=" + age +
            '}';
    }
}
