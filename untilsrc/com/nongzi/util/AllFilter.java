package com.nongzi.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.nongzi.vo.User;



/**
 * web.xml中设置的过滤url规则和spring转发器规则一样，即过滤url /
 * 
 * @author 朱庆杰
 * 
 */
public class AllFilter implements Filter {
 
	private static final Logger log = Logger.getLogger(AllFilter.class);
	public void init(FilterConfig arg0) throws ServletException {
		log.info("全局过滤器成功启动！");
	}
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		((HttpServletRequest) request).setCharacterEncoding("utf-8");
		// 清除缓存
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setHeader("Pragma", "No-cache");
		httpResponse.setHeader("Cache-Control", "no-cache");
		httpResponse.setDateHeader("Expires", 0);
		httpResponse.setContentType("text/html;charset=utf-8");
		httpResponse.setHeader("Connection", "keep-alive");
		httpResponse.setBufferSize(512000);
		// 在request中放置basePath
		String checkSessionPath = ((HttpServletRequest) request).getContextPath();
		String checkBasePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ checkSessionPath + "/";
		((HttpServletRequest) request).setAttribute("basePath", checkBasePath);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestUrl = httpRequest.getRequestURL().toString();
		
		//如果用户没有登录访问user路径将会跳转到登陆页面
		User user = (User) httpRequest.getSession().getAttribute("user");
		if(user==null && (requestUrl.indexOf("/user/") >= 0 || requestUrl.indexOf("/user.html") >= 0)){
			httpResponse.setStatus(302);
			httpResponse.setHeader("Location","http://www.nz101.com/login.html");
			return;
		}
		chain.doFilter(request, response);
		return;
	}
	 public static boolean isInteger(String value) {
		  try {
		   Integer.parseInt(value);
		   return true;
		  } catch (NumberFormatException e) {
		   return false;
		  }
		 }
}
