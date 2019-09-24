package com.byted.ea.risk.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.byted.ea.risk.common.domain.EarMainHistory;
import com.byted.ea.risk.common.mapper.BlacklistLogMapper;
import com.byted.ea.risk.common.service.EarMainHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ear历史数据记录表 服务实现类
 * </p>
 *
 * @author tear-smart
 * @since 2019-08-07
 */
@Service
public class BlacklistLogServiceImpl extends ServiceImpl<BlacklistLogMapper, EarMainHistory> implements EarMainHistoryService {

}
