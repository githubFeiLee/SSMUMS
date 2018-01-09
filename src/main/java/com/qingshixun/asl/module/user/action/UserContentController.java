package com.qingshixun.asl.module.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingshixun.asl.core.ResponseData;
import com.qingshixun.asl.dto.UserDTO;
import com.qingshixun.asl.module.department.service.DepartmentServiceImpl;
import com.qingshixun.asl.module.role.service.RoleServiceImpl;
import com.qingshixun.asl.module.user.service.UserServiceImpl;

@Controller
@RequestMapping("/user/content")
public class UserContentController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private RoleServiceImpl roleService;
	
	@Autowired
	private DepartmentServiceImpl departmentService;
	/**
	 * 添加用户
	 * @param model
	 * @param userId
	 * @return
	 */
	@PostMapping("/add")
	public String mian(Model model,@RequestParam("userId") Long userId){
		model.addAttribute("user", userService.getUser(userId));
		model.addAttribute("roles",roleService.getSimpleRoles()); 
		model.addAttribute("departments", departmentService.getSimpleDepartments());
		
		return "/user/content/add";
	}
	
	/**
	 * 新增或更新用户
	 * @param user
	 * @return
	 */
	@PostMapping("/save")
	@ResponseBody
	public ResponseData save(@ModelAttribute UserDTO user){
		userService.saveOrUpdateUser(user);
		return new ResponseData();
	}
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	@RequestMapping("/remove")
	@ResponseBody
	public ResponseData remove(@RequestParam("userId") Long userId){
		userService.removeUser(userId);
		return new ResponseData();
	}
	/**
	 * 删除多个用户
	 * @param userIds
	 * @return
	 */
	@RequestMapping("/removes")
	@ResponseBody
	public ResponseData removes(@RequestParam("userIds") String userIds){
		userService.removeUsers(userIds);
		return new ResponseData();
	}
	
}
