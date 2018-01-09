package com.qingshixun.asl.module.jurisdiction.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingshixun.asl.core.ResponseData;
import com.qingshixun.asl.dto.JurisdictionDTO;
import com.qingshixun.asl.module.jurisdiction.service.JurisdictionServiceImpl;

@Controller
@RequestMapping("/jurisdiction/content")
public class JurisdictionContentController {
	
	@Autowired
	private JurisdictionServiceImpl jurisdictionService;
	
	/**
	 *进入保存或更新页面
	 * @param model
	 * @param jurisdictionId
	 * @return
	 */
	@RequestMapping("/add")
	public String amin(Model model,@RequestParam("jurisdictionId") Long jurisdictionId){
		model.addAttribute("jurisdiction", jurisdictionService.getJurisdiction(jurisdictionId));
		return "/jurisdiction/content/add";
	}
	
	/**
	 * 添加或更新
	 * @param jurisdiction
	 * @return
	 */
	@RequestMapping(value="/save" ,method=RequestMethod.POST)
	@ResponseBody
	public String save(@ModelAttribute JurisdictionDTO jurisdiction){
		jurisdictionService.saveOrUpdateJurisdiction(jurisdiction);
		return "success";
	}
	/**
	 * 根据id删除单个权限
	 * @param jurisdictionId
	 * @return
	 */
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	@ResponseBody
	public ResponseData remove(@RequestParam("jurisdictionId") Long jurisdictionId){
		
		return jurisdictionService.removeJurisdiction(jurisdictionId);
	}
	
	/**
	 * 根据id删除多个权限
	 * @param jurisdictionIds
	 * @return
	 */
	@RequestMapping(value="/removes",method=RequestMethod.POST)
	@ResponseBody
	public ResponseData removes(@RequestParam("jurisdictionIds") String jurisdictionIds){
		return jurisdictionService.removeJurisdictions(jurisdictionIds);
	}
}
