package com.liuyl.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2019-01-21
 */
@Slf4j
@Service
public class AsyncServiceImpl {
    @Async
    public void test1(){
        try {
            Thread.sleep(10);
            System.out.println("111111111111111111111111111111111111");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void test(){
            System.out.println("222222222222222222222222222");
    }
}
