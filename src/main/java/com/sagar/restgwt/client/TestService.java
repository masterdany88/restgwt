package com.sagar.restgwt.client;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.sagar.restgwt.shared.Routing;

@Path("services")
public interface TestService extends RestService {
	@GET
	//@Path("test")
	@Path(Routing.TestService.getInfo)
	public void getInfo(MethodCallback<TestPojo> test);

	@POST
	@Path(Routing.TestService.setInfo)
	public void setInfo(TestPojo test, MethodCallback<Integer> status);
}

