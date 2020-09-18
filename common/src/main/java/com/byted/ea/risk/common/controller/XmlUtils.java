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
 * @date 2019-08-16
 */
public class XmlUtils {
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("C:\\Users\\admin\\Desktop\\dow\\dow.xml"));
		Element root = document.getRootElement();
		// root.element("sanctionEntity").element("nameAlias")
		// Iterator iterator = root.elementIterator();
		Element records = root.element("Records");
		List<Element> person = records.elements("Person");
		System.out.println(person.size());
	}
}

