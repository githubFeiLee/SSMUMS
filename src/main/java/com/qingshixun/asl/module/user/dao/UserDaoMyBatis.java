package com.qingshixun.asl.module.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qingshixun.asl.core.MyBatisRepository;
import com.qingshixun.asl.dto.UserDTO;

@MyBatisRepository
public interface UserDaoMyBatis {

	/**
	 * ��ȡ�û��б�
	 * @return
	 */
	List<UserDTO> getUsers();
	/**
	 * �����û�id��ȡ�û���Ϣ
	 * @param userId
	 * @return
	 */
	UserDTO getUser(@Param("userId") Long userId);
	/**
	 * ����������û�
	 * @param user
	 */
	void saveOrUpdateUser(UserDTO user);
	/**
	 * �����û�����
	 * @param userId
	 * @param code
	 */
	void updateUserCode(@Param("userId") Long userId,@Param("code") String code);
	/**
	 * ����idɾ���û�
	 * @param userId
	 */
	void removeUser(@Param("userId")Long userId);
	/**
	 * ����idɾ������û�
	 * @param userIds
	 */
	void removeUsers(@Param("userIds")String userIds);
}
