package com.qingshixun.asl.module.jurisdiction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.qingshixun.asl.core.ResponseData;
import com.qingshixun.asl.dto.JurisdictionDTO;
import com.qingshixun.asl.module.jurisdiction.dao.JurisdictionDaoMyBatis;
import com.qingshixun.asl.module.role.service.RoleServiceImpl;

@Service
public class JurisdictionServiceImpl {
	
	@Autowired
	private JurisdictionDaoMyBatis jurisdictionDao;
	@Autowired
	private RoleServiceImpl roleService;
	/**
	 * ��ѯȨ����Ϣ
	 * @return
	 */
	public List<JurisdictionDTO> getJurisdiction(){
		return jurisdictionDao.getJurisdictions();
		
	}
	/**
	 * ������޸�Ȩ����Ϣ
	 * @param jurisdiction
	 */
	public void saveOrUpdateJurisdiction(JurisdictionDTO jurisdiction){
		
		jurisdictionDao.saveOrUpdateJurisdiction(jurisdiction);
	}
	/**
	 * ����id��ȡȨ��
	 * @param id
	 * @return
	 */
	public JurisdictionDTO getJurisdiction(Long id){
		if(id==-1){
			return new JurisdictionDTO();
		}else{
			return jurisdictionDao.getJurisdiction(id);
		}
	}
	/**
	 * ����idɾ��Ȩ��
	 * @param jurisdictionId
	 */
	@CacheEvict(value = "jurisdictionService", allEntries = true)
	public ResponseData removeJurisdiction(Long jurisdictionId){
		ResponseData responseData = new ResponseData();
		//�ж�Ȩ���Ƿ�ʹ��
		if(!roleService.checkRoleJurisdiction(jurisdictionId)){
			responseData.setError("Ȩ���ѱ�ʹ�ã��޷�ɾ����");
			return responseData;
		}
		//ɾ��Ȩ��
		jurisdictionDao.removeJurisdiction(jurisdictionId);
		
		return responseData;
	}
	/**
	 * ����id����ɾ��Ȩ��
	 * @param jurisdictionIds
	 */
	@CacheEvict(value = "jurisdictionService", allEntries = true)
	public ResponseData removeJurisdictions(String jurisdictionIds){
		ResponseData responseData = new ResponseData();
		//����id�ַ���
		String[] idArray = jurisdictionIds.split(",");
		//δ��ʹ�õ�id
		String unusedIds="";
		//ѭ���ж�ÿ��id�Ƿ񱻽�ɫ����
		for(String id:idArray){
			//����δ��ʹ�õ�id���¼��뵽�µ��ַ�����
			if(roleService.checkRoleJurisdiction(Long.valueOf(id))){
				unusedIds+=id+",";
			}
		}
		//�жϿ��Ա�ɾ����id�ַ����Ƿ�Ϊ��
		if(unusedIds.equals("")){
			responseData.setError("ѡ���Ȩ�޾��ѱ�ռ�ã��޷�ɾ����");
			return responseData;
		}
		
		//��ȡ������ַ���
		unusedIds = unusedIds.substring(0,unusedIds.length()-1);
		jurisdictionDao.removeJurisdictions(jurisdictionIds);
		
		return responseData;
	}
	/**
	 * ͨ����ɫid��ȡ��ɫȨ�޹���
	 * @param roleId
	 * @return
	 */
	public List<JurisdictionDTO> getRoleJurisdictions(Long roleId) {
		return jurisdictionDao.getRoleJurisdictions(roleId);
	}

	/**
	 * ��ȡȨ�޻�����Ϣ�б�
	 * @return
	 */
	public List<JurisdictionDTO> getSimpleJurisdictions(){
		return jurisdictionDao.getSimpleJurisdictions();
	}
}
