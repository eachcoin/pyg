package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.pojo.TbBrandExample;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;
	
	@Override
	public List<TbBrand> findAll() {

		return brandMapper.selectByExample(null);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void add(TbBrand tbBrand) {
        brandMapper.insert(tbBrand);
	}

    @Override
    public PageResult findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<TbBrand> pagee = (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageResult(pagee.getTotal(),pagee.getResult());
    }

    @Override
    public PageResult findPage(TbBrand tbBrand, int page, int size) {
        PageHelper.startPage(page, size);//分页

        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (tbBrand != null){
            if (tbBrand.getName() != null && tbBrand.getName().length()>0){
                criteria.andNameLike("%" + tbBrand.getName() + "%");
            }
            if (tbBrand.getFirstChar() != null && tbBrand.getFirstChar().length()>0){
                criteria.andFirstCharLike("%" + tbBrand.getFirstChar() + "%");
            }
        }


        Page<TbBrand> pagee = (Page<TbBrand>) brandMapper.selectByExample(example);

        return new PageResult(pagee.getTotal(),pagee.getResult());



    }

    @Override
    public TbBrand findOne(Long id) {

        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }


}
