package com.liuyl.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2019-01-21
 */
@RestController
public class AsyncController {
    @Autowired
    AsyncServiceImpl service;
    @Autowired
    DealerService dealerService;
    @RequestMapping("test")
    public Object test(){

        service.test1();
        return "一部成功";
    }
    @RequestMapping("test1")
    public Object test1(){
        dealerService.test();
        return "一部成功";
    }
}

