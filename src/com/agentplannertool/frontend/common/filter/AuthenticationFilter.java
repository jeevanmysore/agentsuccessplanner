package com.agentplannertool.frontend.common.filter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {
	private ArrayList urlList;
	private int totalURLS;
	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse res,
		FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;
			String url = request.getServletPath();
			boolean allowedRequest = false;
			for(int i=0; i<totalURLS; i++) {
				String pattern=(String) urlList.get(i);
				if(url.contains(pattern)) {
					allowedRequest = true;
					break;
				}
			}
			if (!allowedRequest) {
				HttpSession session = request.getSession(false);
				if(session==null || session.getAttribute("username")==null)
						response.sendRedirect("./index.jsp");
			}
			else{
				response.addHeader("Pragma","no-cache");
				 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			        response.setDateHeader("Expires", 0);
			}
			chain.doFilter(req, res);
		}
		public void init(FilterConfig config) throws ServletException {
			String urls = config.getInitParameter("avoid-urls");
			StringTokenizer token = new StringTokenizer(urls, ",");
			urlList = new ArrayList();
		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());
		}
			totalURLS = urlList.size();
		}
		}