package com.wjy.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Get extends HttpServletRequestWrapper {

	private String encoding;

	public Get(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	public Get(HttpServletRequest request, String encoding) {
		super(request);
		this.encoding = encoding;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		String value = super.getParameter(name);
		String method = this.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			if (value != null) {
				try {
					value = new String(value.getBytes("ISO-8859-1"), encoding);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return value;
	}

}
