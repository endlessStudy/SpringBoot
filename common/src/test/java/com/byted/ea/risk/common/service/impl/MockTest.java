package com.byted.ea.risk.common.service.impl;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import java.nio.file.Files;

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
 * @date 2019-08-14
 */

public class MockTest {

	@Test
	public void verify_behaviour() throws Exception {
		String xml =
				"<a>\n" +
				"\t<b>\n" +
				"\t123456\n" +
				"\t</b>\n" +
				"</a>";
		Document document = DocumentHelper.parseText(xml);
		Element rootElement = document.getRootElement();
		System.out.println(rootElement.getName());


	}
}
