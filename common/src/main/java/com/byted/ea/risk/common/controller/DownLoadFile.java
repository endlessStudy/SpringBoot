package com.byted.ea.risk.common.controller;

import org.apache.commons.codec.binary.Base64;
import org.dom4j.DocumentException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
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

	@RequestMapping("down1")
	public void downLoad1(String url, String name) throws DocumentException {
		RestTemplate template = new RestTemplateBuilder()
        .basicAuthentication("BytedanceDelta", "keH15rW7")
        .build();
		String auth = "BytedanceDelta:keH15rW7";
		 String safeString = Base64.encodeBase64URLSafeString(auth.getBytes(StandardCharsets.UTF_8));
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Authorization", "Basic " + safeString);
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestHeaders);
		Object response = template.getForObject("https://djrcfeed.dowjones.com/DeltaTracker/WL/xml/", Object.class);


	}

}
