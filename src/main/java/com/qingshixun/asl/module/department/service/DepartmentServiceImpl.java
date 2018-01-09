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
	 * ��ѯ������Ϣ
	 * @return
	 */
	public List<DepartmentDTO> getDepartment(){
		return departmentDao.getDepartments();
		
	}
	/**
	 * ��ȡ���Ż�����Ϣ�б�
	 * @return
	 */
	public List<DepartmentDTO> getSimpleDepartments(){
		return departmentDao.getSimpleDepartments();
	}
	/**
	 * ���ݲ���id��ȡ���ű���
	 * @param departmentId
	 * @return
	 */
	public String getDepartmentCode(Long departmentId){
		return departmentDao.getDepartmentCode(departmentId);
	}
	/**
	 * ������޸Ĳ�����Ϣ
	 * @param department
	 */
	public void saveOrUpdateDepartment(DepartmentDTO department){
		
		departmentDao.saveOrUpdateDepartment(department);
	}
	/**
	 * ����id��ȡ����
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
	 * ����idɾ������
	 * @param departmentId
	 */
	public void removeDepartment(Long departmentId){
		departmentDao.removeDepartment(departmentId);
	}
	/**
	 * ����id����ɾ������
	 * @param departmentIds
	 */
	public void removeDepartments(String departmentIds){
		departmentDao.removeDepartments(departmentIds);
	}
}
