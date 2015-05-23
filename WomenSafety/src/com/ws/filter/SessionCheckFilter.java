package com.ws.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class SessionCheckFilter
 */
@WebFilter("/home.jsp")
public class SessionCheckFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionCheckFilter.class);
    /**
     * Default constructor. 
     */
    public SessionCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try{
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		if(null != session ){
			String id = (String) session.getAttribute("id");
			if(null != id ){
				chain.doFilter(request, response);
				return;
			}else{
				((HttpServletResponse) response).sendRedirect("login.jsp");
				return;
			}
		}else{
			((HttpServletResponse) response).sendRedirect("login.jsp");
			return;
		}
		
		
	}catch(Exception e){
		LOGGER.error("full10");
		LOGGER.error("exception occured during session check", e);
		((HttpServletResponse) response).sendRedirect("login.jsp");
		
		return;
	}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
