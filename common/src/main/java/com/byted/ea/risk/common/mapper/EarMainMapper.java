package com.byted.ea.risk.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.byted.ea.risk.common.domain.EarMain;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 * @author tear-smart
 * @since 2019-08-07
 */
public interface EarMainMapper extends BaseMapper<EarMain> {
	@Select(("select code from ear_main where status = #{status}"))
	List<String> getAllCode(@Param("status") String status);
	@Select("select id from ear_main where type = #{type} and status = 1")
	List<Long> getAllIds(@Param("type") String type);
}
