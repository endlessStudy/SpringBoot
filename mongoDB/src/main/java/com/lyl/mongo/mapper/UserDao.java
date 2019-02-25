package com.lyl.mongo.mapper;

import com.lyl.mongo.entity.UserEntity;

/**
 * @Author liuyl
 * @date 2018-10-28-16:19
 * @description
 */
public interface UserDao {

    void saveUser(UserEntity user);

    UserEntity findUserByUserName(String userName);

    void updateUser(UserEntity user);

    void deleteUserById(Long id);
}
