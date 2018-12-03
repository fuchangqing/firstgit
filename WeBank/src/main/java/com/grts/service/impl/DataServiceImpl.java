package com.grts.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grts.dao.DataBeanMapper;
import com.grts.dto.UserDto;
import com.grts.pojo.DataBean;
import com.grts.service.IDataService;
@Service
public class DataServiceImpl implements IDataService {

	@Resource
	private DataBeanMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DataBean record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(DataBean record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public DataBean selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DataBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DataBean record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public List<DataBean> query(UserDto dto) {
		// TODO Auto-generated method stub
		return dao.query(dto);
	}

	@Override
	public PageInfo<DataBean> queryPage(UserDto dto) {
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<DataBean> list = dao.query(dto);
		PageInfo<DataBean> page=new PageInfo<>(list);
		return page;
	}

	@Override
	public List<DataBean> queryProblem() {
		
		return dao.queryProblem();
	}

}
