package com.besttravelproject.controller;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by А on 08.01.15.
 */
public class Filter implements javax.servlet.Filter {
    private String encoding;
    private FilterConfig filterConfig;

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
        String encodingParam = config.getInitParameter("encoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }
    }
}
