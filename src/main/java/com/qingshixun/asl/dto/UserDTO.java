package com.qingshixun.asl.dto;

public class UserDTO extends BaseDTO{
	// 编码
	private String code;
	// 密码
	private String password;
	// 姓名
	private String name;
	// 手机
	private String mobile;
	// 部门
	private DepartmentDTO department;
	// 角色
	private RoleDTO role;
	// 性别
	private String gender;
	// 状态
	private Boolean status=true;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public DepartmentDTO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
	public RoleDTO getRole() {
		return role;
	}
	public void setRole(RoleDTO role) {
		this.role = role;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getStatusStr(){
		return status ? "启用":"禁用";
	}
}
