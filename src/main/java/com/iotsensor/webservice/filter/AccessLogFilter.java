package com.iotsensor.webservice.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * AccessLogFilter.java
 * @description 
 * Api 호출 시 Access log 생성 (호출 URL, Agent, Access time)
 * 
 * @author SY
 *
 */
public class AccessLogFilter implements Filter{
	
	private static final Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String url = (req.getRequestURL() == null) ? "" : req.getRequestURL().toString();
		String queryString = StringUtils.defaultIfEmpty(req.getQueryString(), "");
		String agent = StringUtils.defaultString(req.getHeader("User-Agent"), "-");
		String fullUrl = url;
		fullUrl += StringUtils.isNotEmpty(queryString) ? "?" + queryString : queryString;
		
		long startDate = System.currentTimeMillis();
		chain.doFilter(req, response);
		long endDate = System.currentTimeMillis();
		String uri = req.getRequestURI();
		
		logger.info("==================================================================");
		logger.info("URL : " + fullUrl);
		logger.info("Agent : " + agent);
		
		if(uri.indexOf("swagger") == -1) {
			logger.info("Access Time : " + (double) (endDate - startDate) + "ms");
		}
		logger.info("==================================================================");
	}
	
	@Override
	public void destroy() {}

}
