package com.byted.ea.risk.common.controller;

import com.google.common.collect.Sets;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
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
 * @date 2019-08-20
 */
public class TypeUtils {
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("D://20190820-lxg.xml"));
		Element root = document.getRootElement();
		// root.element("sanctionEntity").element("nameAlias")
		// Iterator iterator = root.elementIterator();
		Set indSet = Sets.newHashSet();
		Set enSet = Sets.newHashSet();
		List<Element> indElements = root.element("INDIVIDUALS").elements("INDIVIDUAL");
		List<Element> entElements = root.selectSingleNode("//ENTITIES").selectNodes("//ENTITY");
		int count = 0;
		for (Element o : indElements) {
			count++;
			String logicalId = o.element("UN_LIST_TYPE") != null ? o.element("UN_LIST_TYPE").getStringValue() : "";
			indSet.add(logicalId);
			// System.out.println("INDIVIDUALS\t" + logicalId);
		}
		System.out.println(indSet.toString());
		System.out.println(indSet.size());
		count = 0;
		for (Element o : entElements) {
			count++;
			String logicalId = o.element("UN_LIST_TYPE") != null ? o.element("UN_LIST_TYPE").getStringValue() : "";
			enSet.add(logicalId);
			// System.out.println("ENTITY\t" + logicalId );
		}
		System.out.println(enSet.toString());
		System.out.println(enSet.size());
	}
}
