package com.byted.ea.risk.common.rocketmq;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by liuyanlei on 2018/4/23.
 */
@Data
@Accessors(chain = true)
public class User {
    private long id;
    private String name;
    private int age;
    private LocalDateTime dateTime;

}
