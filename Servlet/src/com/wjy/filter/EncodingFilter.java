package com.wjy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {

	private String encoding = "UTF-8";

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		// TODO Auto-generated method stub
		// System.out.println("初始化过滤器！！！");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterchain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		Get get = new Get(request, encoding);
		request.setCharacterEncoding(encoding);
		HttpServletResponse response = (HttpServletResponse) resp;
		response.setContentType("text/html; charset=" + encoding);
		filterchain.doFilter(get, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// System.out.println("销毁过滤器！！！");
	}

}
