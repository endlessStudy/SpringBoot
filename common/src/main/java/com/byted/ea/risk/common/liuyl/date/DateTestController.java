package com.liuyl.date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.liuyl.Swagger.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2019-02-01
 */
@RestController
public class DateTestController {
    @RequestMapping(value = "/date",method = RequestMethod.GET)
    public Object dateTest(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime date) {
        return date;
    }

    @RequestMapping(value = "/time",method = RequestMethod.GET)
    public Object time(TimeBean bean) {
        System.out.println(bean.toString());
        return "success";
    }
}
