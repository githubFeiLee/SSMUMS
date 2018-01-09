package com.qingshixun.asl.module.jurisdiction.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingshixun.asl.module.jurisdiction.service.JurisdictionServiceImpl;

@Controller
@RequestMapping("/jurisdiction/manage")
public class JurisdictionManageController {
	@Autowired
	private JurisdictionServiceImpl jurisdictionService;
	
	@RequestMapping("/list")
	public String main(Model model){
		model.addAttribute("jurisdictions",jurisdictionService.getJurisdiction());
		return "/jurisdiction/manage/list";
	}

}
