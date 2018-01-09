package com.qingshixun.asl.module.department.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingshixun.asl.module.department.service.DepartmentServiceImpl;

@Controller
@RequestMapping("/department/manage")
public class DepartmentManageController {
	@Autowired
	private DepartmentServiceImpl departmentService;
	
	@RequestMapping("/list")
	public String main(Model model){
		model.addAttribute("departments",departmentService.getDepartment());
		return "/department/manage/list";
	}

}
