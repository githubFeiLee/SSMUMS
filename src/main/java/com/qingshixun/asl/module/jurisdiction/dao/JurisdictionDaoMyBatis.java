package com.qingshixun.asl.module.jurisdiction.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qingshixun.asl.core.MyBatisRepository;
import com.qingshixun.asl.dto.JurisdictionDTO;

@MyBatisRepository
public interface JurisdictionDaoMyBatis {
	/**
	 * 通过角色id获取角色权限关联
	 * @param roleId
	 * @return
	 */
	List<JurisdictionDTO> getRoleJurisdictions(@Param("roleId") Long roleId);
	/**
	 * 获取权限
	 * @return
	 */
	List<JurisdictionDTO> getJurisdictions();
	/**
	 * 根据id获取权限
	 * @param id
	 * @return
	 */
	JurisdictionDTO getJurisdiction(@Param("id") Long id);
	/**
	 * 保存或更新权限
	 * @param deparment
	 */
	void saveOrUpdateJurisdiction(JurisdictionDTO jurisdiction);
	
	/**
	 * 根据id删除权限
	 * @param jurisdictionId
	 */
	
	void removeJurisdiction(@Param("jurisdictionId") Long jurisdictionId);
	/**
	 * 根据id批量删除权限
	 * @param jurisdictionIds
	 */
	void removeJurisdictions(@Param("jurisdictionIds") String jurisdictionIds);
	/**
	 * 获取权限基本信息表
	 * @return
	 */
	List<JurisdictionDTO> getSimpleJurisdictions();
}

