package com.elead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/jsp/frame")
	public String frame(){
		return "frame";
		
	}
	@RequestMapping("/jsp/billlist")
	public String billlist(){
		return "billlist";
		
	}
	@RequestMapping("/jsp/providerlist")
	public String providerlist(){
		return"providerlist";
	}
	@RequestMapping("/jsp/userlist")
	public String userlist(){
		return "userlist";
	}
	@RequestMapping("/jsp/pwdmodify")
	public String pwdmodify(){
		return "pwdmodify";
	}
	@RequestMapping("/jsp/billadd")
	public String billadd(){
		return"billadd";
	}
	@RequestMapping("/jsp/provideradd")
	public String provideradd(){
		return "provideradd";
		
	}
}
