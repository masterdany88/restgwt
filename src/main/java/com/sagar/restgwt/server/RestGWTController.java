package com.sagar.restgwt.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class RestGWTController {
	
	@RequestMapping(value = "/setInfo", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody int setInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody TestEntity test) throws ServletException, IOException {
		System.out.println("hit server for setting");
		System.out.println(test.id + " " + test.test2 + " " + test.test);
		return 1;
	}
	
	@RequestMapping(value = "/getInfo", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody TestEntity getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestEntity test = new TestEntity();
		test.id = 1L;
		test.test = "Hello";
		test.test2 = "Hello";
		System.out.println("hit server for getting");
		System.out.println(request.toString());
		System.out.println(response.toString());
		return test;
	}
}