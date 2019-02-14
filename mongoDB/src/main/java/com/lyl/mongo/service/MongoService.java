package com.lyl.mongo.service;

import com.lyl.mongo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author liuyl
 * @date 2018-10-29-10:54
 * @description
 */
public interface MongoService {
    void saveToMongo(Object obj);
}
