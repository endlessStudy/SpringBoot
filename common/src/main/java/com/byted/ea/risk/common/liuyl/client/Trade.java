package com.liuyl.client;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
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
@RequestMapping("trade1")
public class Trade {

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

		list.add("https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		list.add("https://api.trade.gov/v1/trade_events/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		list.add("https://api.trade.gov/v1/trade_leads/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		list.add("https://api.trade.gov/v1/tariff_rates/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		list.add("https://api.trade.gov/ita_faqs/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		list.add("https://api.trade.gov/ita_office_locations/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		list.add("https://api.trade.gov/ita_zipcode_to_post/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		list.add("https://api.trade.gov/business_service_providers/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		list.add("https://api.trade.gov/ita_taxonomies/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		list.add("https://api.trade.gov/v1/de_minimis/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");
		list.add("https://api.trade.gov/market_intelligence/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah");

	}
	private final String appKey = "AoaSDXDrxRcB3GZtTOj5WDah";
	private final String path = "https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah" +
			"&q=chemical";

	// @RequestMapping("screening")
	// public Object getData(@RequestParam String url) {
	// 	String result = restTemplate.getForObject(url, String.class);
	// 	JSONObject jsonObject = JSONObject.parseObject(result);
	// 	return jsonObject.getJSONArray("results").get(0);
	// }
	@RequestMapping("screening/{size}")
	public Object getData(@PathVariable("size") int size) {
		init();
		System.out.println("start!");
		int i = 0;
		long start = System.currentTimeMillis();
		for (String e : list) {
			StringBuilder builder = new StringBuilder();
			builder.append(e + "\t调用接口耗时:");
			i++;
			// log.info(e);
			long allTime = System.currentTimeMillis();
			for (int j = 0; j < size; j++) {
				long startTime = System.currentTimeMillis();
				String result = restTemplate.getForObject(e, String.class);
				builder.append("\t" + (System.currentTimeMillis() - startTime));
				// log.info("调用接口耗时: 1	2" + (System.currentTimeMillis() - startTime));
			}
			log.info(builder.toString());
			// long l = System.currentTimeMillis() - allTime;
			// log.info("{}：调用{}次接口耗时: {},平均耗时{}",i, size, l,l/size);
			// JSONObject jsonObject = JSONObject.parseObject(result);
			// Object results = jsonObject.getJSONArray("results").get(0);
			// try {
			// 	Files.write(Paths.get("d:/json/" + i++ + ".json"), results.toString().getBytes());
			// } catch (IOException ex) {
			// 	System.out.println("2222222222");
			// }
			// System.out.println(e);
		}
		// log.info("所有接口总耗时: System.currentTimeMillis() - start");
		return System.currentTimeMillis() - start;

	}

}
