package com.byted.ea.risk.common.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 */
@Configuration
public class Config {
	@Bean
	public RestTemplate getRestTemplate() {
		 HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        NoRedirectClientHttpRequestFactory httpRequestFactory = new NoRedirectClientHttpRequestFactory();// 此类型不能使用httpClient
        httpRequestFactory.setConnectionRequestTimeout(2000);
        httpRequestFactory.setConnectTimeout(10000);
        httpRequestFactory.setReadTimeout(7200000);
        // HttpClient httpClient = HttpClientBuilder.create()
        //        .setRedirectStrategy(new MyRedirectStrategy())
        //        .build();
		CloseableHttpClient httpClient = HttpClientBuilder.create().disableCookieManagement().disableRedirectHandling().build();
        httpRequestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        // logger.debug("指定字符编码为UTF-8,原编码为ISO-8859-1");
        // restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        // logger.debug("RestTemple默认能转换为application/json，转换追加text/plain类型");
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate;
	}
}