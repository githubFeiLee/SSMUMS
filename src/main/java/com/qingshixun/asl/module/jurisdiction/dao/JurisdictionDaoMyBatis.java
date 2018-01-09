package com.qingshixun.asl.module.jurisdiction.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qingshixun.asl.core.MyBatisRepository;
import com.qingshixun.asl.dto.JurisdictionDTO;

@MyBatisRepository
public interface JurisdictionDaoMyBatis {
	/**
	 * ͨ����ɫid��ȡ��ɫȨ�޹���
	 * @param roleId
	 * @return
	 */
	List<JurisdictionDTO> getRoleJurisdictions(@Param("roleId") Long roleId);
	/**
	 * ��ȡȨ��
	 * @return
	 */
	List<JurisdictionDTO> getJurisdictions();
	/**
	 * ����id��ȡȨ��
	 * @param id
	 * @return
	 */
	JurisdictionDTO getJurisdiction(@Param("id") Long id);
	/**
	 * ��������Ȩ��
	 * @param deparment
	 */
	void saveOrUpdateJurisdiction(JurisdictionDTO jurisdiction);
	
	/**
	 * ����idɾ��Ȩ��
	 * @param jurisdictionId
	 */
	
	void removeJurisdiction(@Param("jurisdictionId") Long jurisdictionId);
	/**
	 * ����id����ɾ��Ȩ��
	 * @param jurisdictionIds
	 */
	void removeJurisdictions(@Param("jurisdictionIds") String jurisdictionIds);
	/**
	 * ��ȡȨ�޻�����Ϣ��
	 * @return
	 */
	List<JurisdictionDTO> getSimpleJurisdictions();
}

