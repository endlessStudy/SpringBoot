package com.byted.ea.risk.common.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.byted.ea.risk.common.domain.EarMain;
import com.byted.ea.risk.common.service.EarMainService;
import com.byted.ea.risk.common.task.EarTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 * @author tear-smart
 * @since 2019-08-07
 */
@Slf4j
@RestController
@RequestMapping("/EarMain")
public class EarMainController {
	@Resource
	private EarMainService earMainService;
	@Resource
	EarTask earTask;
	@RequestMapping("type")
	@ResponseBody
	public void getData2() {
		earTask.processEarData();
	}

	@RequestMapping("test")
	@ResponseBody
	public void get() {
		earMainService.list();
	}
}

