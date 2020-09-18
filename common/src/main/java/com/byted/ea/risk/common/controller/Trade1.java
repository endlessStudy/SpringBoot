package com.byted.ea.risk.common.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 * @date 2019-07-24
 */
@RestController
@Slf4j
public class Trade1 {
	@Resource
	public RestTemplate restTemplate;

	private final Map<String, String> map = new HashMap<>();
	private final List<String> list = new ArrayList<>();

	public void init() {
		// list.add("https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		// list.add("https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&q" +
		// 		"=chemical");
		// list.add("https://api.trade.gov/v1/trade_leads/search?&api_key" +
		// 		"=AoaSDXDrxRcB3GZtTOj5WDah");
		// list.add("https://api.trade.gov/v1/trade_leads/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&q=electrical");
		// list.add("https://api.trade.gov/v1/trade_leads/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&industries
		// =Information Networks");
		// list.add("https://api.trade.gov/v1/trade_leads/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		// list.add("https://api.trade.gov/v1/trade_leads/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&q=electrical");
		// list.add("https://api.trade.gov/v1/tariff_rates/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		// list.add("https://api.trade.gov/v1/tariff_rates/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&q=horses");
		// list.add("https://api.trade.gov/v1/de_minimis/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		// list.add("https://api.trade.gov/v1/de_minimis/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&q=China");

		// list.add("https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&size
		// =20000&offset=1");
		// list.add("https://api.trade.gov/v1/trade_events/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&size=20000&offset
		// =1");
		// list.add("https://api.trade.gov/v1/trade_leads/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&size=20000&offset
		// =1");
		// list.add("https://api.trade.gov/v1/tariff_rates/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&size=20000&offset
		// =1");
		// list.add("https://api.trade.gov/ita_faqs/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&size=20000&offset=1");
		// list.add("https://api.trade.gov/ita_office_locations/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&size=20000
		// &offset=1");
		// list.add("https://api.trade.gov/ita_zipcode_to_post/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&size=20000
		// &offset=1");
		// list.add("https://api.trade.gov/business_service_providers/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&size
		// =20000&offset=1");
		// list.add("https://api.trade.gov/ita_taxonomies/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&size=20000&offset
		// =1");
		// list.add("https://api.trade.gov/v1/de_minimis/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&size=20000&offset=1");
		// list.add("https://api.trade.gov/market_intelligence/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&size=20000
		// &offset=1");
		list.add("https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah&sources" +
				"=%s&size=20000&offset=1");

	}

	private final String appKey = "AoaSDXDrxRcB3GZtTOj5WDah";
	private final String path = "https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah";

	// @RequestMapping("screening")
	// public Object getData(@RequestParam String url) {
	// 	String result = restTemplate.getForObject(url, String.class);
	// 	JSONObject jsonObject = JSONObject.parseObject(result);
	// 	return jsonObject.getJSONArray("results").get(0);
	// }
	@RequestMapping("screening")
	public Object getData() {
        String url = "https://webgate.ec.europa.eu/europeaid/fsd/fsf/public/files/xmlFullSanctionsList_1_1/content?token=n002v1eq";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return result.getBody();

	}

	@RequestMapping("type")
	public void getData1() {
		long start = System.currentTimeMillis();
		String url = "https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah" +
				"&sources" +
				"=EL&size=100&offset=%d";
		// String type = "DPL,EL,UVL,ISN,DTC,13599,FSE,PLC,561,SSI,SDN";
		String type = "EL";
		restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		Object result = restTemplate.getForObject(String.format(url, 0), Object.class);
		JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(result));
		int total = jsonObject.getIntValue("total");
		try {
			for (int i = 100; i < total; i = i + 100) {
				String result1 = restTemplate.getForObject(String.format(url, i), String.class);
				JSONArray result2 = JSONObject.parseObject(result1).getJSONArray("results");
				jsonObject.getJSONArray("results").add(result2);
			}
			Files.write(Paths.get("d:/json/" + type + ".json"), jsonObject.toJSONString().getBytes());
		} catch (IOException ex) {
			System.out.println("2222222222");
		}
		System.out.println(type);
		// log.info("所有接口总耗时: System.currentTimeMillis() - start");
	}


	@RequestMapping("type2")
	public void getData2() {
		System.out.println("start");
		String url = "https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah" +
				"&sources" +
				"=%s&size=2&offset=1";
		String type = "DPL,EL,UVL,ISN,DTC,13599,FSE,PLC,561,SSI,SDN";
		for (String e : type.split(",")) {
			String result = restTemplate.getForObject(String.format(url, e), String.class);
			System.out.println(e + "\t" + JSONObject.parseObject(result).getString("total"));
		}
	}

	@RequestMapping("type3")
	public void RRR() {
		System.out.println("start");
		String url = "https://ec.europa.eu/external_relations/cfsp/sanctions/list/version4/global/global.xml";
		// https://scsanctions.un.org/resources/xml/en/consolidated.xml
		String result = restTemplate.getForObject(url, String.class);
		try {
			Files.write(Paths.get("d:/json/2.json"), result.getBytes());
		} catch (IOException ex) {
			System.out.println("2222222222");
		}

	}
	public static String revert(String unicode) {

	    StringBuffer string = new StringBuffer();

	    String[] hex = unicode.split("\\\\u");

	    for (int i = 1; i < hex.length; i++) {

	        // 转换出每一个代码点
	        int data = Integer.parseInt(hex[i], 16);

	        // 追加成string
	        string.append((char) data);
	    }

	    return string.toString();
	}
}
