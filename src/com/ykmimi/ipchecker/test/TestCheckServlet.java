package com.ykmimi.ipchecker.test;

import com.ykmimi.ipchecker.servlet.CheckServlet;

public class TestCheckServlet {

	public static void main(String[] args) {

		CheckServlet cs = new CheckServlet();
		System.out.println(cs.getAddressResult("www.baidu.com"));
		System.out.println(cs.getAddressResult("www.ykmimi.com"));
		System.out.println(cs.getAddressResult("www.yahoo.com"));
		System.out.println(cs.getAddressResult("www.google.com"));
		System.out.println(cs.getAddressResult("www.wsdss.com"));
		System.out.println(cs.getAddressResult("www.12312.com"));
	}

}
