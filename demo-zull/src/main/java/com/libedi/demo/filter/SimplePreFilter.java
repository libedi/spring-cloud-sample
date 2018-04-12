package com.libedi.demo.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class SimplePreFilter extends ZuulFilter {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String filterType() {
		return FilterType.PRE.toString();
	}

	@Override
	public int filterOrder() {
		return 1;
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		
		return null;
	}

}
