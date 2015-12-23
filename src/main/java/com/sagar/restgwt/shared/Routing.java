package com.sagar.restgwt.shared;

public class Routing {
	private static final String separator = "/";

	public static class TestService {
		private static final String testService = "testService" + separator;
		public static final String getInfo = testService + "getInfo";
		public static final String setInfo = testService + "setInfo";
	}
}
