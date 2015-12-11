package com.sagar.restgwt.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sagar.restgwt.shared.Routing;



@Controller
public class RestGWTController {
	
	@RequestMapping(value = "/setInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody int setInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody TestEntity test) throws ServletException, IOException {
		System.out.println("Hit server for setting");
		System.out.println(test.getId() + " " + test.getTest() + " " + test.getTest2());
		return 1;
	}
	
	@RequestMapping(value = Routing.getInfo, method = RequestMethod.GET, headers = "Accept=application/json")
	//public @ResponseBody TestEntity getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	public @ResponseBody TestEntity getInfo() throws ServletException, IOException {
		TestEntity test = new TestEntity();
		test.setId(1L);
		test.setTest("Hello");
		test.setTest2("Hello");
		System.out.println("Hit server for getting");
		return test;
	}
}