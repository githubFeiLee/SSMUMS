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
	 * 查询权限信息
	 * @return
	 */
	public List<JurisdictionDTO> getJurisdiction(){
		return jurisdictionDao.getJurisdictions();
		
	}
	/**
	 * 保存或修改权限信息
	 * @param jurisdiction
	 */
	public void saveOrUpdateJurisdiction(JurisdictionDTO jurisdiction){
		
		jurisdictionDao.saveOrUpdateJurisdiction(jurisdiction);
	}
	/**
	 * 根据id获取权限
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
	 * 根据id删除权限
	 * @param jurisdictionId
	 */
	@CacheEvict(value = "jurisdictionService", allEntries = true)
	public ResponseData removeJurisdiction(Long jurisdictionId){
		ResponseData responseData = new ResponseData();
		//判断权限是否被使用
		if(!roleService.checkRoleJurisdiction(jurisdictionId)){
			responseData.setError("权限已被使用，无法删除！");
			return responseData;
		}
		//删除权限
		jurisdictionDao.removeJurisdiction(jurisdictionId);
		
		return responseData;
	}
	/**
	 * 根据id批量删除权限
	 * @param jurisdictionIds
	 */
	@CacheEvict(value = "jurisdictionService", allEntries = true)
	public ResponseData removeJurisdictions(String jurisdictionIds){
		ResponseData responseData = new ResponseData();
		//解析id字符串
		String[] idArray = jurisdictionIds.split(",");
		//未被使用的id
		String unusedIds="";
		//循环判断每个id是否被角色关联
		for(String id:idArray){
			//对于未被使用的id重新加入到新的字符串中
			if(roleService.checkRoleJurisdiction(Long.valueOf(id))){
				unusedIds+=id+",";
			}
		}
		//判断可以被删除的id字符串是否为空
		if(unusedIds.equals("")){
			responseData.setError("选择的权限均已被占用，无法删除！");
			return responseData;
		}
		
		//截取多余的字符串
		unusedIds = unusedIds.substring(0,unusedIds.length()-1);
		jurisdictionDao.removeJurisdictions(jurisdictionIds);
		
		return responseData;
	}
	/**
	 * 通过角色id获取角色权限关联
	 * @param roleId
	 * @return
	 */
	public List<JurisdictionDTO> getRoleJurisdictions(Long roleId) {
		return jurisdictionDao.getRoleJurisdictions(roleId);
	}

	/**
	 * 获取权限基本信息列表
	 * @return
	 */
	public List<JurisdictionDTO> getSimpleJurisdictions(){
		return jurisdictionDao.getSimpleJurisdictions();
	}
}
