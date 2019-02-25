package com.lyl.mongo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lyl.mongo.entity.User;
import org.apache.ibatis.annotations.Update;

/**
 * @Author liuyl
 * @date 2018-10-24-10:27
 * @description
 */
public interface UserMapper extends BaseMapper<User> {
    @Update("update user set version = version + #{version} ")
    int updateUser(int version);

}
