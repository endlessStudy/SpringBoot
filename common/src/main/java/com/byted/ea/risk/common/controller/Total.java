package com.byted.ea.risk.common.controller;

import com.google.common.collect.Sets;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

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
 * @date 2019-08-28
 */
public class Total {
	public static void main(String[] args) throws DocumentException {
		// jndzh();
		yg();
	}

	private static void jndzh() throws DocumentException {
		SAXReader reader = new SAXReader();
		String url = "D://xml//综合加拿大自治制裁名单.xml";
		Document document = reader.read(new File(url));
		Element root = document.getRootElement();
		List<Node> list = root.selectNodes("//record/Item");
		Set set = Sets.newHashSet();
		for (Node node : list) {
			set.add(node.getStringValue());
		}
		System.out.println("综合加拿大自治制裁名单,total=" + set.size());
	}

	//腐败外国官员受害者法规
	private static void fb() throws DocumentException {
		SAXReader reader = new SAXReader();
		String url = "D://xml//腐败外国官员受害者法规.xml";
		Document document = reader.read(new File(url));
		Element root = document.getRootElement();
		List<Node> list = root.selectNodes("//record/Item");
		Set set = Sets.newHashSet();
		for (Node node : list) {
			set.add(node.getStringValue());
		}
		System.out.println("腐败外国官员受害者法规,total=" + set.size());
	}
//腐败外国官员受害者法规
	private static void yg() throws DocumentException {
		SAXReader reader = new SAXReader();
		String url = "D://xml//ConList.xml";
		Document document = reader.read(new File(url));
		Element root = document.getRootElement();
		List<Element> consolidatedList = root.elements("ConsolidatedList");
		Set set = Sets.newHashSet();
		for (Element node : consolidatedList) {
			set.add(node.element("ID").getStringValue());
		}
		System.out.println("ConList,total=" + set.size()+","+consolidatedList.size());
	}

	//瑞士xml
	private static void rs() throws DocumentException {
		SAXReader reader = new SAXReader();
		String url = "D://xml//瑞士.xml";
		Document document = reader.read(new File(url));
		Element root = document.getRootElement();
		// List<Node> list = root.selectNodes("//swiss-sanctions-list/target/@ssid");
		List<Element> list = root.elements("target");
		Set set = Sets.newHashSet();
		Set reSet = Sets.newHashSet();
		StringBuilder stringBuilder = new StringBuilder();
		int size = list.size();
		int count = 0;
		int i = 1;

		for (Element node : list) {
			// count++;
			// if (count * 50 >= size) {
			// 	System.out.println(count);
			// 	write(stringBuilder.toString(), i++);
			// 	stringBuilder = new StringBuilder();
			// 	count = 0;
			// }
			// stringBuilder.append(node.getParent().asXML());
			// System.out.println(node.asXML());
			String ssid = node.attribute("ssid").getStringValue();
			if (set.contains(ssid)) {
				reSet.add(ssid);
				continue;
			}
			set.add(ssid);
		}
		// write(stringBuilder.toString(), i++);
		System.out.println("瑞士,total=" + set.size());
		System.out.println("瑞士,total=" + reSet.size());
	}

	private static void write(String data, int count) {
		File file = new File("D://xml//" + count + ".xml");
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false),
					StandardCharsets.ISO_8859_1));
			writer.write(data);
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
	}
}
