package com.byted.ea.risk.common.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.byted.ea.risk.common.domain.EarMain;
import com.byted.ea.risk.common.domain.EarMainHistory;
import com.byted.ea.risk.common.mapper.EarMainMapper;
import com.byted.ea.risk.common.service.EarMainHistoryService;
import com.byted.ea.risk.common.service.EarMainService;
import com.byted.ea.risk.common.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 * @author tear-smart
 * @since 2019-08-07
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class EarMainServiceImpl extends ServiceImpl<EarMainMapper, EarMain> implements EarMainService {

	@Resource
	private EarMainMapper earMainMapper;
	@Resource
	private EarMainHistoryService earMainHistoryService;
	@Override
	public Map<String, ResultVo> processData(Map<String, JSONArray> map) {
        List<EarMain> earMains = this.list();
        //获取数据库全部数据
        Map<String, List<EarMain>> earMainMap = earMains.stream().collect(Collectors.groupingBy(EarMain::getCode));
        //将数据保存数据库中
        return saveDataToDB(map, earMainMap);
    }

    /**
     * @param map 各个类型数据
     * @param earMainMap ear数据，key为code，value该条数据
     * @return
     */
    private Map<String, ResultVo> saveDataToDB(Map<String, JSONArray> map, Map<String, List<EarMain>> earMainMap) {
        Map<String, ResultVo> resultVoMap = new HashMap<>();
        //key: type,value: 该类型所有的值
        Set<Map.Entry<String, JSONArray>> entries = map.entrySet();
        for (Map.Entry<String, JSONArray> entry : entries) {
            ResultVo resultVo = new ResultVo();
            Set<Long> insertSet = new HashSet<>();
            Set<Long> updateSet = new HashSet<>();
            Set<Long> currentSet = new HashSet<>();
            Set<Long> deleteSet = new HashSet<>();
            String earType = entry.getKey();
            for (Object o : entry.getValue()) {
                JSONObject earJson = JSONObject.parseObject(o.toString());
                String md5Hex = DigestUtils.md5Hex(earJson.toString());
                String uid = earJson.getString("id");
                String name = earJson.getString("name");
                String code = DigestUtils.md5Hex(uid + "_" + earType);
                // 数据不存在
                if (!earMainMap.containsKey(code)) {
                    EarMain earMain = new EarMain();
                    earMain.setUid(uid);
                    earMain.setName(name);
                    earMain.setCode(code);
                    earMain.setContent(earJson.toString());
                    earMain.setStatus("1");
                    earMain.setType(earType);
                    earMain.setMd5(md5Hex);
                    earMainMapper.insert(earMain);
                    insertSet.add(earMain.getId());
                } else {
                    EarMain earMain = earMainMap.get(code).get(0);
                    String md5 = earMain.getMd5();
                    //数据已存在，但存在更新
                    if (!StringUtils.equals(md5, md5Hex)) {
                        log.info("update data! id={},status=1", earMain.getId());
                        saveEarHistory(earMain);
                        earMain.setContent(earJson.toString());
                        earMain.setStatus("1");
                        earMainMapper.updateById(earMain);
                        updateSet.add(earMain.getId());
                    } else if (StringUtils.equals(earMain.getStatus(), "0")) {
                        log.info("update data! id={},status={}", earMain.getId(), "0");
                        //数据已存在，但已经被删除
                        saveEarHistory(earMain);
                        earMain.setStatus("1");
                        earMainMapper.updateById(earMain);
                        updateSet.add(earMain.getId());
                    } else {
                        //无任何变化
                        currentSet.add(earMain.getId());
                    }
                }
            }
            resultVo.setInsertSet(insertSet);
            resultVo.setUpdateSet(updateSet);
            resultVo.setCurrentSet(currentSet);
            List<Long> allIds = earMainMapper.getAllIds(earType);
            allIds.forEach(id -> {
                if (!insertSet.contains(id) && !updateSet.contains(id) && !currentSet.contains(id)) {
                    EarMain earMain = earMainMapper.selectById(id);
                    saveEarHistory(earMain);
                    earMain.setStatus("0");
                    earMainMapper.updateById(earMain);
                    deleteSet.add(id);
                }
            });
            resultVo.setDeleteSet(deleteSet);
            resultVoMap.put(earType, resultVo);
        }

        return resultVoMap;
    }

    private void saveEarHistory(EarMain earMain) {
        EarMainHistory earMainHistory = new EarMainHistory();
        BeanUtils.copyProperties(earMain, earMainHistory);
        earMainHistory.setCategory("ear");
        earMainHistoryService.save(earMainHistory);
    }

}
