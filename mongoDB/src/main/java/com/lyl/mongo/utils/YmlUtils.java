package com.lyl.mongo.utils;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-14
 */
public class YmlUtils {

    public static void main(String[] args) throws Exception {


        YamlPropertySourceLoader yml = new YamlPropertySourceLoader();
        InputStreamSource inputStreamSource = new FileUrlResource("D:\\workplace\\SpringBoot\\mongoDB\\src\\main\\resources\\config.yml");
        List<PropertySource<?>> user = yml.load("user", (Resource) inputStreamSource);
        user.forEach(item -> {
            System.out.println(item.getProperty("user.name.first"));
        });
    }
}