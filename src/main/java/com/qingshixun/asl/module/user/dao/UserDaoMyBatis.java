package com.qingshixun.asl.module.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qingshixun.asl.core.MyBatisRepository;
import com.qingshixun.asl.dto.UserDTO;

@MyBatisRepository
public interface UserDaoMyBatis {

	/**
	 * 获取用户列表
	 * @return
	 */
	List<UserDTO> getUsers();
	/**
	 * 根据用户id获取用户信息
	 * @param userId
	 * @return
	 */
	UserDTO getUser(@Param("userId") Long userId);
	/**
	 * 新增或更新用户
	 * @param user
	 */
	void saveOrUpdateUser(UserDTO user);
	/**
	 * 更新用户编码
	 * @param userId
	 * @param code
	 */
	void updateUserCode(@Param("userId") Long userId,@Param("code") String code);
	/**
	 * 根据id删除用户
	 * @param userId
	 */
	void removeUser(@Param("userId")Long userId);
	/**
	 * 根据id删除多个用户
	 * @param userIds
	 */
	void removeUsers(@Param("userIds")String userIds);
}
