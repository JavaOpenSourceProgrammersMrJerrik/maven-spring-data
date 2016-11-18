package com.mangocity.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mangocity.spring.domain.UserVO;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@RequestMapping(value = "/index.action")
	public String index(HttpServletRequest request, @RequestBody UserVO userVO) {
		System.out.println("userVO: " + userVO);
		return "index";
	}

	@RequestMapping(value = "/getJSON.action")
	public String getJSON(HttpServletRequest request,
			@RequestBody(required = true) String json,
			@RequestHeader(name = "Accept") String accept) {
		System.out.println("getJSON: " + json);
		System.out.println("Accept: " + accept);
		return "index";
	}
}
