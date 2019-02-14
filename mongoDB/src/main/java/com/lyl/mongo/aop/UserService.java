package com.lyl.mongo.aop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liuyl
 * @date 2018-11-13-16:25
 * @description
 */
@Service
public class UserService {

    public void add(String string){
        System.out.println("UserService add()");
    }

    public boolean delete(String string){
        System.out.println("UserService delete()");
        return true;
    }

    public void edit(){
        System.out.println("UserService edit()");
        int i = 5/0;
    }


}