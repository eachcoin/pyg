package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	public List<TbBrand> findAll();

	/**
	 * 删除
	 * @param ids
	 */
	void delete(Long[] ids);

	void add(TbBrand tbBrand);

	PageResult findPage(int page, int size);

	PageResult findPage(TbBrand tbBrand, int page, int size);
	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public TbBrand findOne(Long id);

	/**
	 * 修改
	 * @param brand
	 */
	public void update(TbBrand brand);


}
