package com.grts.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grts.dao.UserBeanMapper;
import com.grts.dto.BaseUserRole;
import com.grts.dto.UserDto;
import com.grts.pojo.UserBean;
import com.grts.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private UserBeanMapper dao;

	@Override
	public int deleteByPrimaryKey(Integer userid) {
		dao.deleteUserAndRoleById(userid);
		return dao.deleteByPrimaryKey(userid);
	}

	@Override
	public int insert(UserBean user) {
		// TODO Auto-generated method stub
		return dao.insert(user);
	}

	@Override
	public int insertSelective(UserBean user) {
		int count = dao.insertSelective(user);
		List<Integer> rids = user.getRids();
		if (rids != null) {
			for (Integer rid : rids) {
				dao.saveUseridAndRoleid(new BaseUserRole(user.getUserid(), rid));
			}
		}
		return count;
	}

	@Override
	public UserBean selectByPrimaryKey(Integer userid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(userid);
	}

	@Override
	public int updateByPrimaryKeySelective(UserBean user) {
		dao.updateByPrimaryKeySelective(user);
		dao.deleteUserAndRoleById(user.getUserid());
		List<Integer> rids = user.getRids();
		if (rids != null) {
			for (Integer rid : rids) {
				dao.saveUseridAndRoleid(new BaseUserRole(user.getUserid(), rid));
			}
		}
		return 0;
	}

	@Override
	public int updateByPrimaryKey(UserBean user) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(user);
	}

	@Override
	public PageInfo<UserBean> query(UserDto dto) {
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<UserBean> ulist = dao.query(dto);
		PageInfo<UserBean> page = new PageInfo<UserBean>(ulist);
		return page;
	}

	@Override
	public List<Integer> queryRoleidByUserid(Integer userid) {
		// TODO Auto-generated method stub
		return dao.queryRoleidByUserid(userid);
	}

	@Override
	public UserBean selectByUsername(String username) {
		
		return dao.selectByUsername(username);
	}

	@Override
	public UserBean login(String username, String password) {
		UserBean user = dao.selectByUsername(username);
		if(user.getPassword().equals(password)){
			return user;
		}else{
			return null;
		}		
	}

	@Override
	public List<UserBean> selectGroupUser(Integer did) {
		// TODO Auto-generated method stub
		return dao.selectGroupUser(did);
	}

}
