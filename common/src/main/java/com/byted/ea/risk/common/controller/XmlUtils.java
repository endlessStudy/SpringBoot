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
 * @date 2019-08-16
 */
public class XmlUtils {
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("D://20190820-FULL-1_1(xsd).xml"));
		Element root = document.getRootElement();
		// root.element("sanctionEntity").element("nameAlias")
		// Iterator iterator = root.elementIterator();
		List<Element> entityList = root.elements("sanctionEntity");
		int count = 0;
		Set<String> idSet = Sets.newHashSet();
		Set<String> multIdSet = Sets.newHashSet();
		for (Element o : entityList) {
			String logicalId = o.attribute("logicalId").getValue();
			if (idSet.contains(logicalId)) {
				multIdSet.add(logicalId);
			} else {
				idSet.add(logicalId);
			}
		}
		System.out.println(idSet.size());
		System.out.println(multIdSet.size());
	}
}

