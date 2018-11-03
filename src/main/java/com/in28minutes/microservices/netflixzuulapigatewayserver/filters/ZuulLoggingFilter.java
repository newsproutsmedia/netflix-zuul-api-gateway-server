package com.in28minutes.microservices.netflixzuulapigatewayserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // when should the filter happen?
    @Override
    public String filterType() {
        return "pre";
    }

    // set a priority order for different filters
    @Override
    public int filterOrder() {
        return 1;
    }

    // for each request should this filter be executed or not
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        // get current HTTP request that is being handled
        HttpServletRequest request =
                RequestContext.getCurrentContext().getRequest();

        logger.info("request -> {} request uri -> {}", request, request.getRequestURI());

        return null;
    }
}
