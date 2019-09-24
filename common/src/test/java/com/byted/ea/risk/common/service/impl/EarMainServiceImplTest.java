package com.byted.ea.risk.common.service.impl;


import com.byted.ea.risk.common.mapper.EarMainMapper;
import com.byted.ea.risk.common.service.EarMainHistoryService;
import com.byted.ea.risk.common.service.EarMainService;
import com.byted.ea.risk.common.vo.ResultVo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
 * @date 2019-08-11
 */

public class EarMainServiceImplTest {
	@Mock
	private EarMainService earMainService;
	@Mock
	private EarMainMapper earMainMapper;
	@Mock
	private EarMainHistoryService blacklistLogService;

	// @Mock
	// private EarMainService earMainService;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		//这句话执行以后，bookDao等bookService依赖的bean会自动注入到abcService中。
	}


	@Test
	public void processData() {
		ResultVo vo = new ResultVo();
		vo.setFileName("fileName");
		// Mockito.when(earMainService.processData(null)).thenReturn(vo);
		// ResultVo resultVo = earMainService.processData(null);
		// System.out.println(resultVo);
		// Map map = new HashMap();
		// map.put("534706c3564e48e0c3f59c040723c4cd1dca1295", "{{\"end_date\":\"2024-07-24\",\"source_list_url\":\"http://bit.ly/1Qi5heF\"," +
		// 		"\"source_information_url\":\"http://bit.ly/1iwxiF0\",\"addresses\":[{\"country\":\"PRC\"," +
		// 		"\"address\":\"#602, NO. 39, NONG #78, SHOU GUANG ROAD\",\"city\":\"PU DONG SHANGHAI\",\"state\":\"\"," +
		// 		"\"postal_code\":\"\"}],\"name\":\"QIANG HU\",\"federal_register_notice\":\"81 F.R. 7304 2/11/16\"," +
		// 		"\"standard_order\":\"Y\",\"id\":\"534706c3564e48e0c3f59c040723c4cd1dca1295\",\"source\":\"Denied " +
		// 		"Persons List (DPL) - Bureau of Industry and Security\",\"remarks\":\"FR NOTICE ADDED\"," +
		// 		"\"start_date\":\"2016-02-03\"}}");
		//
		// earMainService.processData(map);
	}

}