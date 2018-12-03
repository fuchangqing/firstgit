package com.grts.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grts.dao.RoleBeanMapper;
import com.grts.dto.UserDto;
import com.grts.pojo.RoleBean;
import com.grts.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Resource
	private RoleBeanMapper dao;

	@Override
	public int deleteByPrimaryKey(Integer rid) {
		int count=dao.selectCountById(rid);
		if(count>0){
			return 1;
		}else{
			dao.deleteRoleAndMenuById(rid);
			dao.deleteByPrimaryKey(rid);
		}	
		return 0;
	}

	@Override
	public int insert(RoleBean role) {
		// TODO Auto-generated method stub
		return dao.insert(role);
	}

	@Override
	public int insertSelective(RoleBean role) {
		int count = dao.insertSelective(role);
		List<Integer> mids = role.getMids();
		if (mids != null) {
			for (Integer mid : mids) {
				dao.saveRoleAndMenuById(role.getRid(), mid);
			}
		}
		return count;
	}

	@Override
	public RoleBean selectByPrimaryKey(Integer rid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(rid);
	}

	@Override
	public int updateByPrimaryKeySelective(RoleBean role) {
		dao.updateByPrimaryKeySelective(role);
		dao.deleteRoleAndMenuById(role.getRid());
		dao.deleteRoleAndUserById(role.getRid());
		List<Integer> mids = role.getMids();
		if(mids!=null){
			for (Integer mid : mids) {
				dao.saveRoleAndMenuById(role.getRid(), mid);
			}
		}
		return 0;
	}

	@Override
	public int updateByPrimaryKey(RoleBean role) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(role);
	}

	@Override
	public PageInfo<RoleBean> queryPage(UserDto dto) {
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<RoleBean> list = dao.query(dto);
		PageInfo<RoleBean> page = new PageInfo<>(list);
		return page;
	}

	@Override
	public List<RoleBean> query(UserDto dto) {
		// TODO Auto-generated method stub
		return dao.query(dto);
	}

	@Override
	public List<Integer> queryMidByRoleid(Integer rid) {
		// TODO Auto-generated method stub
		return dao.queryMidByRoleid(rid);
	}

	@Override
	public RoleBean selectByRolename(String rolename) {
		// TODO Auto-generated method stub
		return dao.selectByRolename(rolename);
	}

}
