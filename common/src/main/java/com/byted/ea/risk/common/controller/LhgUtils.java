package com.byted.ea.risk.common.controller;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
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
 * @date 2019-08-19
 */
public class LhgUtils {
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("D://20190821-lxg.xml"));
		Element root = document.getRootElement();
		// root.element("sanctionEntity").element("nameAlias")
		// Iterator iterator = root.elementIterator();
		List<Element> indElements = root.element("INDIVIDUALS").elements("INDIVIDUAL");
		List<Element> entElements =root.selectSingleNode("//ENTITIES").selectNodes("//ENTITY");
		int count = 0;
		for (Element o : indElements) {
			count++;
			String logicalId = o.element("DATAID") != null ? o.element("DATAID").getStringValue() : "";
			String firstName = o.element("FIRST_NAME") != null ? o.element("FIRST_NAME").getStringValue() : "";
			String secondName = o.element("SECOND_NAME") != null ? o.element("SECOND_NAME").getStringValue() : "";
			String thirdName = o.element("THIRD_NAME") != null ? o.element("THIRD_NAME").getStringValue() : "";
			System.out.println("INDIVIDUALS\t" + logicalId + "\t" + firstName + " " + secondName + " " + thirdName);
		}
		System.out.println(count);
		count = 0;
		for (Element o : entElements) {
			count++;
			String logicalId = o.element("DATAID") != null ? o.element("DATAID").getStringValue() : "";
			String firstName = o.element("FIRST_NAME") != null ? o.element("FIRST_NAME").getStringValue() : "";
			String secondName = o.element("SECOND_NAME") != null ? o.element("SECOND_NAME").getStringValue() : "";
			String thirdName = o.element("THIRD_NAME") != null ? o.element("THIRD_NAME").getStringValue() : "";
			System.out.println("ENTITY\t" + logicalId + "\t" + firstName + " " + secondName + " " + thirdName);
		}
		System.out.println(count);
	}
}
