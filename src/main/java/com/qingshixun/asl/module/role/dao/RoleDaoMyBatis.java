/*****************************************************************************
 * Copyright (c) 2016, www.qingshixun.com
 *
 * All rights reserved
 *
*****************************************************************************/
package com.qingshixun.asl.module.role.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qingshixun.asl.core.MyBatisRepository;
import com.qingshixun.asl.dto.RoleDTO;

@MyBatisRepository
public interface RoleDaoMyBatis {
	
	/**
	 * 获取角色列表
	 * @return
	 */
	List<RoleDTO> getRoles();
	
	/**
	 * 根据id获取角色
	 * @param roleId
	 * @return
	 */
	RoleDTO getRole(@Param("roleId") Long roleId);
	
	/**
	 * 新增或更新角色，并填充角色id
	 * @param role
	 */
	void saveOrUpdateRole(RoleDTO role);
	
	/**
	 * 新增角色权限关联
	 * @param role
	 */
	void saveRoleJurisdictions(RoleDTO role);
	
	/**
	 * 根据角色id删除角色
	 * @param roleId
	 */
	void removeRole(@Param("roleId") Long roleId);
	
	/**
	 * 根据角色id删除角色权限关联
	 * @param roleId
	 */
	void removeRoleJurisdictions(@Param("roleId") Long roleId);
	
	/**
	 * 删除多个角色
	 * @param roleIds
	 */
	void removeRoles(@Param("roleIds") String roleIds);
	
	/**
	 * 删除多个角色的多个权限
	 * @param roleIds
	 */
	void removeRolesJurisdictions(@Param("roleIds") String roleIds);
	/**
	 * 获取角色基本信息列表
	 * @return
	 */
	List<RoleDTO> getSimpleRoles();
	/**
	 * 根据权限ID验证权限是否被关联
	 * @param jurisdictionId
	 * @return
	 */
	Integer checkRoleJurisdiction(@Param("jurisdictionId") Long jurisdictionId);
}
