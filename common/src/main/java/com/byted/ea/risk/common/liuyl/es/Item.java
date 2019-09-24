package com.liuyl.es;

import lombok.Data;

/**
 * @author admin
 */
@Data
public class Item {
	/**
	 * id
	 */
	private Long id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 分类
	 */
	private String category;
	/**
	 * 品牌
	 */
	private String brand;
	/**
	 * 价格
	 */
	private Double price;
	/**
	 * 图片地址
	 */
	private String images;
}