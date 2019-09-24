package com.byted.ea.risk.common.controller;


import com.alibaba.fastjson.JSONObject;

/**
 * <p>
 * ear历史数据记录表 前端控制器
 * </p>
 *
 * @author tear-smart
 * @since 2019-08-07
 */
public class BlacklistLogController {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject1 = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();
		JSONObject jsonObject3 = new JSONObject();
		jsonObject3.put("a", "a");
		jsonObject3.put("b", "b");
		jsonObject2.put("2", jsonObject3);
		jsonObject1.put("1", jsonObject2);
		jsonObject.put("0", jsonObject1);
		System.out.println(jsonObject.toString());
		jsonObject1.put("2", 4);
		System.out.println(jsonObject.toString());
		JSONObject map = new JSONObject();
		JSONObject map1 = new JSONObject();
		JSONObject map2 = new JSONObject();
		map2.put("4", "a");
		map1.put("1", map2);
		map.put("0", map1);
		jsonObject.fluentPutAll(map);
		System.out.println(jsonObject.toString());
	}
}

