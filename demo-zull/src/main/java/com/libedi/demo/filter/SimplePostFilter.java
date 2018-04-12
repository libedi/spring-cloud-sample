package com.libedi.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class SimplePostFilter extends ZuulFilter {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public String filterType() {
		return FilterType.POST.toString();
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
		String result = ctx.getResponseBody();
		
		logger.info("Result : " + result);
		
		return null;
	}

}
