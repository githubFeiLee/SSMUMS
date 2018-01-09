package com.qingshixun.asl.module.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingshixun.asl.module.user.service.UserServiceImpl;

@Controller
@RequestMapping("/user/manage")
public class UserManageController {

	@Autowired
	private UserServiceImpl userService;
	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("users", userService.getUsers());
		return "/user/manage/list";
	}
}
