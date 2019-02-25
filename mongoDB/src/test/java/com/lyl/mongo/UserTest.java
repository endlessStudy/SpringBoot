package com.lyl.mongo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lyl.mongo.aop.UserService;
import com.lyl.mongo.entity.User;
import com.lyl.mongo.mapper.UserMapper;
import com.lyl.mongo.service.MongoService;
import com.lyl.mongo.utils.Config;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJAopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author liuyl
 * @date 2018-10-22-17:55
 * @description
 */
@RunWith(SpringRunner.class)
@ComponentScan({"com.lyl.mongo"})
@MapperScan("com.lyl.mongo.mapper")
@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService;
    @Resource
    MongoService mongoService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    MongoTemplate mongoTemplate;
    @Test
    public void testAop(){
        userService.add("123");
    }
    @Test
    public void testConfig(){
    }
    @Test
    public void lockTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "jack");
        jsonObject.put("password", "2222222");
        System.out.println(jsonObject.toString());
        mongoService.saveToMongo(jsonObject);
    }

    @Test
    public void est() {
        DBObject dbObject = new BasicDBObject();
        DBObject fieldObject = new BasicDBObject();
        fieldObject.put("_id", false);
        Query query = new BasicQuery(dbObject.toString(), fieldObject.toString());
        List<JSONObject> reUser = mongoTemplate.find(query, JSONObject.class, "reUser");
        System.out.println(reUser.toString());
        reUser.forEach(user -> {
            System.out.println(user.toString());
            userMapper.insert(JSONObject.toJavaObject(user, User.class));
        });
        String s = "111";
        s.toUpperCase();


    }


    @Test
    public void test() {
        User user = new User();
        user.setVersion(3);
        EntityWrapper<User> wrapper = new EntityWrapper<>();


        userMapper.update(user, new EntityWrapper<User>().eq("username", "jack7"));
        // List list = userMapper.selectList(new EntityWrapper<User>().and("username={0}","jack"));
        // System.out.println(list.toString());
    }

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void test1() {
        List data = new ArrayList();
        data.add("a");
        data.add("b");
        data.add("c");
        String forObject = restTemplate.getForObject("http://localhost:8080/api/data", String.class, data);
        System.out.println(forObject);
    }
}
