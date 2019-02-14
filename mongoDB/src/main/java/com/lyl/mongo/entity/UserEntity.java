package com.lyl.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author liuyl
 * @date 2018-10-28-16:19
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    private Long id;
    private String userName;
    private Integer age;
    private String email;
}