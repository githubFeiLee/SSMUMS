package com.qingshixun.asl.module.department.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingshixun.asl.dto.DepartmentDTO;
import com.qingshixun.asl.module.department.service.DepartmentServiceImpl;

@Controller
@RequestMapping("/department/content")
public class DepartmentContentController {
	
	@Autowired
	private DepartmentServiceImpl departmentService;
	
	/**
	 *进入保存或更新页面
	 * @param model
	 * @param departmentId
	 * @return
	 */
	@RequestMapping("/add")
	public String amin(Model model,@RequestParam("departmentId") Long departmentId){
		model.addAttribute("department", departmentService.getDepartment(departmentId));
		return "/department/content/add";
	}
	
	/**
	 * 添加或更新
	 * @param department
	 * @return
	 */
	@RequestMapping(value="/save" ,method=RequestMethod.POST)
	@ResponseBody
	public String save(@ModelAttribute DepartmentDTO department){
		departmentService.saveOrUpdateDepartment(department);
		return "success";
	}
	/**
	 * 根据id删除多个部门
	 * @param departmentId
	 * @return
	 */
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	@ResponseBody
	public String remove(@RequestParam("departmentId") Long departmentId){
		departmentService.removeDepartment(departmentId);
		return "success";
	}
	
	@RequestMapping(value="/removes",method=RequestMethod.POST)
	@ResponseBody
	public String removes(@RequestParam("departmentIds") String departmentIds){
		departmentService.removeDepartments(departmentIds);
		System.out.println(departmentIds);
		return "success";
	}
}
