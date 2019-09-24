package com.byted.ea.risk.common.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.byted.ea.risk.common.domain.Lhg;
import com.byted.ea.risk.common.mapper.LhgMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
 * @date 2019-08-20
 */
@Service
@RestController
public class MapUtils extends ServiceImpl<LhgMapper, Lhg> {
	@Resource
	private RestTemplate restTemplate;
	@Resource
	private LhgMapper lhgMapper;

	//https://www.sanctionsmap.eu/api/v1/regime/1?
	@RequestMapping("lhg")
	public void data() {
		int[] countrys = new int[]{1, 2, 4, 7, 9, 46, 10, 47, 11, 12, 14, 15, 16, 17, 18, 19, 21, 22, 23, 43, 45, 42,
				25, 28, 8, 20, 26, 27, 29,
				30, 31, 34, 32, 6, 5, 33, 35, 36, 37, 38, 44, 39, 40};
		List<Lhg> lhgData = new ArrayList<>();
		for (int country : countrys) {
			System.out.println(country);
			String url = "https://www.sanctionsmap.eu/api/v1/regime/" + country;
			String result = restTemplate.getForObject(url, String.class);
			JSONObject jsonObject = JSONObject.parseObject(result);
			JSONArray measures = jsonObject.getJSONObject("response").getJSONArray("measures");
			measures.forEach(item -> {
				JSONObject items = (JSONObject) item;
				//制裁类型
				String title = items.getJSONObject("type").getString("title");
				JSONArray lists = items.getJSONArray("lists");
				lists.forEach(list -> {
					JSONObject object = (JSONObject) list;
					JSONArray members = object.getJSONArray("members");
					members.forEach(member -> {
						Lhg lhg = new Lhg();
						lhg.setCountry(String.valueOf(country));
						lhg.setTitle(title);
						JSONObject mem = (JSONObject) member;
						String type = mem.getString("type");
						String name = mem.getString("name");
						String fsdId = mem.getString("FSD_ID");
						String programme = mem.getString("programme");
						lhg.setType(type);
						lhg.setName(name);
						lhg.setFsdid(fsdId);
						lhg.setProgramme(programme);
						lhgData.add(lhg);
						if (lhgData.size() > 500) {
							this.saveBatch(lhgData);
							lhgData.clear();
						}
					});
				});
			});
		}
		this.saveBatch(lhgData);
	}
}
