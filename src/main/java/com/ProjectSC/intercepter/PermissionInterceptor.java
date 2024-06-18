package com.ProjectSC.intercepter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class PermissionInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		String uri = request.getRequestURI();
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null && uri.endsWith("/productRegister-view")) {
			response.sendRedirect("/user/login-view");
			return false;
		}
		if (userId == null && uri.endsWith("/register")) {
			response.sendRedirect("/user/login-view");
			return false;
		}
		if (userId == null && uri.endsWith("/postCreate-view")) {
			response.sendRedirect("/user/login-view");
			return false;
		}
		if (userId == null && uri.endsWith("/create")) {
			response.sendRedirect("/user/login-view");
			return false;
		}
		if (userId == null && uri.startsWith("/cart")) {
			response.sendRedirect("/user/login-view");
			return false;
		}
		if (userId == null && uri.startsWith("/order")) {
			response.sendRedirect("/user/login-view");
			return false;
		}
		if (userId == null && uri.startsWith("/payment")) {
			response.sendRedirect("/user/login-view");
			return false;
		}
		if (userId != null && uri.startsWith("/user")) {
			response.sendRedirect("/main/main");
			return false;
		}
		
		return true;
	}
}
