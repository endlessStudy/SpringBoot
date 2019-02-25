package com.liuyl.Swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
