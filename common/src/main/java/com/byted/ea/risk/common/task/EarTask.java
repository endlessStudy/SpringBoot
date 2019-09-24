package com.byted.ea.risk.common.task;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.byted.ea.risk.common.service.EarMainService;
import com.byted.ea.risk.common.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * |****************************** *_* ******************************|
 * |   __                                                      __    |
 * | _/  |_  ____ _____ _______    ______ _____ _____ ________/  |_  |
 * | \   __\/ __ \\__  \\_  __ \  /  ___//     \\__  \\_  __ \   __\ |
 * |  |  | \  ___/ / __ \|  | \/  \___ \|  Y Y  \/ __ \|  | \/|  |   |
 * |  |__|  \___  >____  /__|    /____  >__|_|  (____  /__|   |__|   |
 * |            \/     \/             \/      \/     \/              |
 * |                                                                 |
 * |****************************** *_* ******************************|
 * </p>
 * @author tear-smart
 * @date 2019-08-09
 */
@Component
@Slf4j
public class EarTask {
	@Value("${ear.apiKey}")
	private String apiKey;
	@Value("${ear.url}")
	private String url;
	@Value("${ear.type}")
	private String type;
	@Resource
	private EarMainService earMainService;
	@Resource
	private RestTemplate restTemplate;
	public void processEarData() {

        String[] strings = type.split(",");
        Map<String, JSONArray> map = new HashMap<>();
        String type = "";
        //获取所有数据,并按照类型放入map中
        try {
            for (String string : strings) {
                log.info("download data start! type={}", string);
                type = string;
                JSONArray fullArray = new JSONArray();
                String response = restTemplate.getForObject(String.format(url, string, 0), String.class);
                JSONObject earJson = JSONObject.parseObject(response);
                JSONArray result = earJson.getJSONArray("results");
                fullArray.addAll(result);
                log.info("type {} start!,total:{}", string, earJson.getString("total"));
                int total = earJson.getIntValue("total");
                if (total > 100) {
                    for (int i = 100; i <= total; i = i + 100) {
                        String format = String.format(url, string, i);
                        String obj = restTemplate.getForObject(format, String.class);
                        JSONObject resObj = JSONObject.parseObject(obj);
                        fullArray.addAll(resObj.getJSONArray("results"));
                    }
                }
                map.put(string, fullArray);
            }
            //处理所有类型的数据
            Map<String, ResultVo> resultVoMap = earMainService.processData(map);
            resultVoMap.forEach((k, v) -> {
                // dealEarEsData(v);
                log.info("type={},insertSize={},updateSize={},,deleteSize={}",
                        k,v.getInsertSet().size(), v.getUpdateSet().size(), v.getDeleteSet().size());

                // larkService.DailyUpdateSendLark(v.getInsertSet().size(), v.getUpdateSet().size(), v.getDeleteSet().size(), true, "ear " + k);
            });
        } catch (Exception e) {
            // larkService.DailyUpdateSendLark(0, 0, 0, false, "ear " + type);
            throw e;
        }
    }
}
