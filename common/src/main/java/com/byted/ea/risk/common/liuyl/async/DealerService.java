package com.liuyl.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerService {

   @Autowired
   private AsyncUpdate asyncUpdate;
   @Autowired
   AsyncServiceImpl service;

   public void test() {
      try {
         asyncUpdate.updateDealerAsync();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
 
   //一些代码
}
