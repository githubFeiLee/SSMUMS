package com.qingshixun.asl.module.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshixun.asl.dto.DepartmentDTO;
import com.qingshixun.asl.module.department.dao.DepartmentDaoMyBatis;

@Service
public class DepartmentServiceImpl {
	
	@Autowired
	private DepartmentDaoMyBatis departmentDao;
	
	/**
	 * 查询部门信息
	 * @return
	 */
	public List<DepartmentDTO> getDepartment(){
		return departmentDao.getDepartments();
		
	}
	/**
	 * 获取部门基本信息列表
	 * @return
	 */
	public List<DepartmentDTO> getSimpleDepartments(){
		return departmentDao.getSimpleDepartments();
	}
	/**
	 * 根据部门id获取部门编码
	 * @param departmentId
	 * @return
	 */
	public String getDepartmentCode(Long departmentId){
		return departmentDao.getDepartmentCode(departmentId);
	}
	/**
	 * 保存或修改部门信息
	 * @param department
	 */
	public void saveOrUpdateDepartment(DepartmentDTO department){
		
		departmentDao.saveOrUpdateDepartment(department);
	}
	/**
	 * 根据id获取部门
	 * @param id
	 * @return
	 */
	public DepartmentDTO getDepartment(Long id){
		if(id==-1){
			return new DepartmentDTO();
		}else{
			return departmentDao.getDepartment(id);
		}
	}
	/**
	 * 根据id删除部门
	 * @param departmentId
	 */
	public void removeDepartment(Long departmentId){
		departmentDao.removeDepartment(departmentId);
	}
	/**
	 * 根据id批量删除部门
	 * @param departmentIds
	 */
	public void removeDepartments(String departmentIds){
		departmentDao.removeDepartments(departmentIds);
	}
}
