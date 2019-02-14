package com.lyl.mongo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lyl.mongo.entity.User;
import com.lyl.mongo.service.MongoService;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liuyl
 * @date 2018-11-06-14:01
 * @description
 */
@Service
public class MongoServiceImpl implements MongoService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveToMongo(Object obj) {
        JSONObject json = (JSONObject) JSONObject.toJSON(obj);
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(json.getString("username")));
        Object one = mongoTemplate.findOne(query, Object.class, "user");
        if (null == one || "".equals(one)) {
            System.out.println(obj.toString());
            mongoTemplate.save(obj,"user");
            System.out.println("无重复-------");
            return;
        }
        System.out.println(obj.toString());
        mongoTemplate.save(obj, "reUser");
        System.out.println("重复-------");
        return;

    }
}
