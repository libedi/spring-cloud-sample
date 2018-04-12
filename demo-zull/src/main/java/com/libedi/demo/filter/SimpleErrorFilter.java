package com.libedi.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class SimpleErrorFilter extends ZuulFilter {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	@Override
	public String filterType() {
		return FilterType.ERROR.toString();
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
		logger.error("ERROR OCCUR!");
		return null;
	}

}
