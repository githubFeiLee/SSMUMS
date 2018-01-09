package com.qingshixun.asl.module.department.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qingshixun.asl.core.MyBatisRepository;
import com.qingshixun.asl.dto.DepartmentDTO;

@MyBatisRepository
public interface DepartmentDaoMyBatis {

	/**
	 * ��ȡ����
	 * @return
	 */
	List<DepartmentDTO> getDepartments();
	/**
	 * ��ȡ������Ϣ�б�
	 * @return
	 */
	List<DepartmentDTO> getSimpleDepartments();
	/**
	 * ���ݲ���id��ȡ���ű���
	 * @param departmentId
	 * @return
	 */
	String getDepartmentCode(@Param("departmentId") Long departmentId);
	/**
	 * ����id��ȡ����
	 * @param id
	 * @return
	 */
	DepartmentDTO getDepartment(@Param("id") Long id);
	/**
	 * �������²���
	 * @param deparment
	 */
	void saveOrUpdateDepartment(DepartmentDTO department);
	
	/**
	 * ����idɾ������
	 * @param departmentId
	 */
	
	void removeDepartment(@Param("departmentId") Long departmentId);
	/**
	 * ����id����ɾ������
	 * @param departmentIds
	 */
	void removeDepartments(@Param("departmentIds") String departmentIds);
}
