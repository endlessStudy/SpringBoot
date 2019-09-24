package com.byted.ea.risk.common.controller;

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
public class DownLoadFile {

	@Resource
	private RestTemplate restTemplate;
	@RequestMapping("down")
	public void downLoad(String url,String name) {
		BufferedWriter writer = null;
		String data = restTemplate.getForObject(url, String.class);
		File file = new File("D://xml//" +name+ ".xml");
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.ISO_8859_1));
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
		System.out.println("文件写入成功！");
	}

	public static void main(String[] args) {
		String url = "https://laws-lois.justice.gc.ca/eng/XML/SOR-2017-233.xml";
		String name = "腐败外国官员受害者法规";
		// downLoad(url,name);
	}
}
