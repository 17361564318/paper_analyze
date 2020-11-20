package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HighchartsController extends BaseController{

	@RequestMapping("/to_cj")
	public String to_cj() {
		return "to_cj";
	}
	@RequestMapping("/to_nyd")
	public String to_nyd() {
		return "to_nyd";
	}
	@RequestMapping("/to_jg")
	public String to_jg() {
		return "to_jg";
	}

}
