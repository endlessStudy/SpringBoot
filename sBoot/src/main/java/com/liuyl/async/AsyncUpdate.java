package com.liuyl.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class AsyncUpdate {
 
   @Autowired
   private AsyncServiceImpl userService;
 
   /**
    *异步更新
    */
   @Async
   public void updateDealerAsync() throws Exception {
       //篇幅有限就不贴代码
   }
}