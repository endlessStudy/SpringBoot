package com.lyl.mongo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author liuyl
 * @date 2018-10-22-17:52
 * @description
 */
@Data
@TableName(value = "user")
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    @TableId(value="id",type = IdType.AUTO)
    private String id;
    @TableField(value = "username")
    private String username;
    @TableField(value = "password")
    private String password;
    //
    // private Map map;

    @Version
    private Integer version = 1;

}

