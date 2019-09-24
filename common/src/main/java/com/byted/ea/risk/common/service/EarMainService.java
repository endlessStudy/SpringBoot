package com.byted.ea.risk.common.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;
import com.byted.ea.risk.common.domain.EarMain;
import com.byted.ea.risk.common.vo.ResultVo;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 * @author tear-smart
 * @since 2019-08-07
 */
public interface EarMainService extends IService<EarMain> {
	Map<String, ResultVo> processData(Map<String, JSONArray> map);

}
