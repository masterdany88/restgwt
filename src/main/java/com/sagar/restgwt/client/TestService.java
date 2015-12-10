package com.sagar.restgwt.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestService;
import org.fusesource.restygwt.client.RestServiceProxy;

import com.google.gwt.core.client.GWT;

@Path("/service")
public interface TestService extends RestService {
	public static class Util {
		private static TestService instance;

		public static TestService getService() {
			if (instance == null) {
				instance = GWT.create(TestService.class);
			}
			Resource resource = new Resource(GWT.getModuleBaseURL() + "service");
			((RestServiceProxy) instance).setResource(resource);
			return instance;
		}
	}

	@GET
	@Path("/loadInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void getInfo(MethodCallback<TestPojo> callback);
}