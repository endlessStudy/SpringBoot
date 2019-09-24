package com.byted.ea.risk.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ear历史数据记录表
 * </p>
 * @author tear-smart
 * @since 2019-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ear_main_history")
@ApiModel(value = "BlacklistLogModel对象", description = "ear历史数据记录表")
public class EarMainHistory extends Model<EarMainHistory> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private long id;
	@ApiModelProperty(value = "数据id")
	private String uid;

	@ApiModelProperty(value = "uid+type生成的md5")
	private String code;

	@ApiModelProperty(value = "内容")
	private String content;

	@ApiModelProperty(value = "数据类型DPL,EL,UVL,ISN,DTC,13599,FSE,PLC,561,SSI,SDN")
	private String type;
	private String category;
	@ApiModelProperty(value = "姓名")
	private String name;

	private String md5;

	@ApiModelProperty(value = "状态(0:删除,1:未删除)")
	private String status;
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;


	@Override
	protected Serializable pkVal() {
		return id;
	}
}
