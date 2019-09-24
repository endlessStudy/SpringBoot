package com.liuyl.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
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

	private Map<String, String> map = new HashMap<>();
	private List<String> list = new ArrayList<>();

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

	private String appKey = "AoaSDXDrxRcB3GZtTOj5WDah";
	private String path = "https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah";

	// @RequestMapping("screening")
	// public Object getData(@RequestParam String url) {
	// 	String result = restTemplate.getForObject(url, String.class);
	// 	JSONObject jsonObject = JSONObject.parseObject(result);
	// 	return jsonObject.getJSONArray("results").get(0);
	// }
	@RequestMapping("screening")
	public Object getData() {
		init();
		System.out.println("start!");
		int i = 0;
		long start = System.currentTimeMillis();
		for (String e : list) {
			String substring = e.substring(e.indexOf("/", 21), e.lastIndexOf("/")).replace("/", "");
			String result = restTemplate.getForObject(e, String.class);
			JSONArray results = JSONObject.parseObject(result).getJSONArray("results");
			System.out.println(results.size());
			try {
				Files.write(Paths.get("d:/json/" + substring + ".json"), result.getBytes());
			} catch (IOException ex) {
				System.out.println("2222222222");
			}
			// System.out.println(e);
		}
		// log.info("所有接口总耗时: System.currentTimeMillis() - start");
		return System.currentTimeMillis() - start;

	}

	@RequestMapping("type")
	public Object getData1() {
		long start = System.currentTimeMillis();
		String url = "https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah" +
				"&sources" +
				"=%s&size=20000&offset=1";
		String type = "DPL,EL,UVL,ISN,DTC,13599,FSE,PLC,561,SSI,SDN";
		// String type = "ISN";
		// String type = "BIS";
		for (String e : type.split(",")) {
			String result = restTemplate.getForObject(String.format(url, e), String.class);
			System.out.println(e + "\t" + JSONObject.parseObject(result).getString("total"));
			// JSONArray results = JSONObject.parseObject(result).getJSONArray("results");
			// System.out.println(results.size());
			// try {
			// 	Files.write(Paths.get("d:/json/" + e + ".json"), result.getBytes());
			// } catch (IOException ex) {
			// 	System.out.println("2222222222");
			// }
			// System.out.println(e);
		}
		// log.info("所有接口总耗时: System.currentTimeMillis() - start");
		return System.currentTimeMillis() - start;

	}


	@RequestMapping("type2")
	public Object getData2() {
		long start = System.currentTimeMillis();
		String url = "https://api.trade.gov/consolidated_screening_list/search?api_key=AoaSDXDrxRcB3GZtTOj5WDah" +
				"&sources" +
				"=%s&size=20000&offset=1";
		String type = "DPL,EL,UVL,ISN,DTC,13599,FSE,PLC,561,SSI,SDN";
		for (String e : type.split(",")) {
			String result = restTemplate.getForObject(String.format(url, e), String.class);
			JSONArray results = JSONObject.parseObject(result).getJSONArray("results");
		}
		return System.currentTimeMillis() - start;
	}
}
