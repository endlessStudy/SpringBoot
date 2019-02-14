package com.lyl.mongo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import javafx.embed.swing.JFXPanel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author liuyl
 * @date 2018-11-08-18:44
 * @description
 */
@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/data")
    public String getData(HttpServletRequest request,@Param(value = "data") String data){
        // String param = request.getParameter("data");
        JSONArray jsonArray = JSON.parseArray(data);
        if (jsonArray == null) {
            return "空指针！";
        }
        jsonArray.forEach(p->{
            System.out.println(p);
        });
        return jsonArray.toString();
    }
}
