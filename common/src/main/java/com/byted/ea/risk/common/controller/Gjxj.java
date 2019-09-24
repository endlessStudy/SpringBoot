package com.byted.ea.risk.common.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.StandardCharsets;

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
 * @date 2019-08-19
 */
@RestController
public class Gjxj {
	@Resource
	private RestTemplate restTemplate;

	@RequestMapping("gjxj")
	public void downLoad() {
		String url = "https://ws-public.interpol.int/notices/v1/un/persons?page=%d&resultPerPage=100";
		String detail = "https://ws-public.interpol.int/notices/v1/un/persons/";

		BufferedWriter writer = null;
		String data;
		int total;
		JSONArray jsonArray = new JSONArray();
		StringBuilder stringBuilder = new StringBuilder();
		JSONArray array = new JSONArray();
		for (int i = 1;i<3 ; i++) {
			data = restTemplate.getForObject(String.format(url, i), String.class);
			JSONObject jsonObject = JSONObject.parseObject(data);
			if (data == null) {
				break;
			}
			jsonArray.addAll(jsonObject.getJSONObject("_embedded").getJSONArray("notices"));

		}
		int size = 0;
		for (Object o : jsonArray) {
			System.out.println(size++);
			if (o instanceof JSONObject) {
				JSONObject object = (JSONObject) o;
				String id = object.getString("entity_id").replaceAll("/", "-");
				String details = restTemplate.getForObject(detail + id, String.class);
				array.add(JSONObject.parse(details));
			}
		}
		File file = new File("D://xml//gjxj.json");
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false),
					StandardCharsets.ISO_8859_1));
			writer.write(array.toJSONString());
		} catch (IOException e) {
			System.out.println("系统异常");
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("文件写入成功！");
	}

	public static void main(String[] args) {
		String url = "https://laws-lois.justice.gc.ca/eng/XML/SOR-2017-233.xml";
		String name = "腐败外国官员受害者法规";
		// downLoad(url,name);
	}
}
