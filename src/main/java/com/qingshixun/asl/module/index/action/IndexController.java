package com.qingshixun.asl.module.index.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private MessageSource messageSource;

	@RequestMapping("")
	public String main(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "/index";
	}

	@RequestMapping("/{language}")
	public String main(Model model, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String language) {
		// �ָ����
		String[] languages = language.split("_");

		// ����ϵͳ����
		setLanguage(model, request, response, new Locale(languages[0], languages[1]));

		return "/index";
	}

	private void setLanguage(Model model, HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// ��ȡlocaleResover
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		// ����locale��Ϣ
		localeResolver.setLocale(request, response, locale);
		// ������ȷ��locale��Ϣ��ҳ��
		model.addAttribute("encoding", messageSource.getMessage("encoding", new Object[0], locale));
	}
}