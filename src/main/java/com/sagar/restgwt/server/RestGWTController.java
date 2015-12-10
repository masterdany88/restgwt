package com.sagar.restgwt.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sagar.restgwt.client.TestPojo;

@Controller
public class RestGWTController {
	@RequestMapping(value = "/loadInfo", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody TestDomain handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestDomain confirmation = new TestDomain();
		confirmation.test = "Hello";
		System.out.println("hit server");
		return confirmation;
	}
}