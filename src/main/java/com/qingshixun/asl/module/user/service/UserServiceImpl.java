package com.qingshixun.asl.module.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshixun.asl.dto.RoleDTO;
import com.qingshixun.asl.dto.UserDTO;
import com.qingshixun.asl.module.department.service.DepartmentServiceImpl;
import com.qingshixun.asl.module.user.dao.UserDaoMyBatis;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDaoMyBatis userDao;
	
	@Autowired
	private DepartmentServiceImpl departmentService;
	/**
	 * 获取用户列表
	 * @param userId
	 * @return
	 */
	public List<UserDTO> getUsers(){
		return userDao.getUsers();
	}
	
	/**
	 * 根据用户id获取用户信息
	 * @param userId
	 * @return
	 */
	public UserDTO getUser(Long userId){
		
		if(userId==-1l)	{
			return new UserDTO();
		}
		return userDao.getUser(userId);
	}
	/**
	 * 根据id删除用户
	 * @param userId
	 */
	public void removeUser(Long userId){
		userDao.removeUser(userId);
	}
	/**
	 * 根据id删除多个用户
	 * @param userIds
	 */
	public void removeUsers(String userIds){
		userDao.removeUsers(userIds);
	}
	
	public void saveOrUpdateUser(UserDTO user){
		//新增并填充id
		userDao.saveOrUpdateUser(user);
		//获取部门编码
		String code = departmentService.getDepartmentCode(user.getDepartment().getId());
		//根据用户id和部门code，更新用户code
		userDao.updateUserCode(user.getId(),code+"-"+user.getId());
	}
}
