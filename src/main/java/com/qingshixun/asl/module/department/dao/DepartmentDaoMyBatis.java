package com.qingshixun.asl.module.department.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qingshixun.asl.core.MyBatisRepository;
import com.qingshixun.asl.dto.DepartmentDTO;

@MyBatisRepository
public interface DepartmentDaoMyBatis {

	/**
	 * 获取部门
	 * @return
	 */
	List<DepartmentDTO> getDepartments();
	/**
	 * 获取部门信息列表
	 * @return
	 */
	List<DepartmentDTO> getSimpleDepartments();
	/**
	 * 根据部门id获取部门编码
	 * @param departmentId
	 * @return
	 */
	String getDepartmentCode(@Param("departmentId") Long departmentId);
	/**
	 * 根据id获取部门
	 * @param id
	 * @return
	 */
	DepartmentDTO getDepartment(@Param("id") Long id);
	/**
	 * 保存或更新部门
	 * @param deparment
	 */
	void saveOrUpdateDepartment(DepartmentDTO department);
	
	/**
	 * 根据id删除部门
	 * @param departmentId
	 */
	
	void removeDepartment(@Param("departmentId") Long departmentId);
	/**
	 * 根据id批量删除部门
	 * @param departmentIds
	 */
	void removeDepartments(@Param("departmentIds") String departmentIds);
}
