package com.byted.ea.risk.common.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

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
 * @date 2019-08-27
 */
public class RsXml {
	static Set<String> set = new HashSet();
	static Map<String, Set> map = new HashMap<>();
	static Map<String, Object> result = new HashMap<>();
	static JSONObject jsonObject = new JSONObject();

	public static void main(String[] args) throws DocumentException {
		// String test = "d://test.xml";
		// String rs = "d://xml//联合国综合制裁名单.xml";
		// String rs = "d://xml//欧盟制裁名单.xml";
		// String rs = "d://xml//consolidate.xml";
		String rs = "d://xml//ConList.xml";
		// String rs = "d://xml//综合加拿大自治制裁名单.xml";
		// String rs = "d://xml//腐败外国官员受害者法规.xml";
		// String rs = "d://xml//建立实体清单的规定.xml";
		// String rs = "d://xml//瑞士.xml";
		getFiled(rs);
	}
	public static void getFiled(String url) throws DocumentException {
		JSONObject object = new JSONObject();
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(url));
		Element root = document.getRootElement();
		processElement(root, "");
		for (String s : set) {
			String[] split = s.split(":");
			List<String> strings = Arrays.asList(split);
			Iterator<String> iterator = strings.iterator();
			jointData(jsonObject, iterator);
		}
		System.out.println(jsonObject.toString().replaceAll("\\{\\}","\"\""));
	}
	private static void processJson(JSONObject jo1,JSONObject jo2){
		jo1.forEach((k,v) -> {
			if (v == null) {
				jo1.put(k, "");
			}else {
				processJson(jo1.getJSONObject(k),jo1);
			}
		});
	}
	private static void jointData(JSONObject object1, Iterator<String> iterator) {
		if (iterator.hasNext()) {
			String name = iterator.next();
			if (object1.containsKey(name)) {
				jointData(object1.getJSONObject(name), iterator);
			} else {
				object1.put(name, data(iterator));
			}
		}
	}
	public static JSONObject data(Iterator<String> iterator){
		String name = "";
		JSONObject obj2 =obj2 = new JSONObject();
		if (iterator.hasNext()) {

			name = iterator.next();
			JSONObject data = data(iterator);
			obj2.put(name, data);
			return obj2;
		}
		return obj2;
	}
	private static String processElement(Element element, String oldName) {
		String name = "";
		if (StringUtils.isBlank(oldName)) {
			name = element.getName();
		}else{
			name = oldName + ":" + element.getName();
		}
		if (element.isTextOnly()) {
			set.add(name);
			return name;
		} else {
			Iterator<Element> iterator = element.elementIterator();
			while (iterator.hasNext()) {
				Element subEle = iterator.next();
				processElement(subEle, name);
			}
			return name;
		}
	}
}
