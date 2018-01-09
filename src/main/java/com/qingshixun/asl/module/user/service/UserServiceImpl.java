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
	 * ��ȡ�û��б�
	 * @param userId
	 * @return
	 */
	public List<UserDTO> getUsers(){
		return userDao.getUsers();
	}
	
	/**
	 * �����û�id��ȡ�û���Ϣ
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
	 * ����idɾ���û�
	 * @param userId
	 */
	public void removeUser(Long userId){
		userDao.removeUser(userId);
	}
	/**
	 * ����idɾ������û�
	 * @param userIds
	 */
	public void removeUsers(String userIds){
		userDao.removeUsers(userIds);
	}
	
	public void saveOrUpdateUser(UserDTO user){
		//���������id
		userDao.saveOrUpdateUser(user);
		//��ȡ���ű���
		String code = departmentService.getDepartmentCode(user.getDepartment().getId());
		//�����û�id�Ͳ���code�������û�code
		userDao.updateUserCode(user.getId(),code+"-"+user.getId());
	}
}
