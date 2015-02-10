package com.besttravelproject.controller;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by А on 08.01.15.
 */
public class Filter implements javax.servlet.Filter {
    private String encoding;

    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        String encodingParam = config.getInitParameter("encoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }
    }
}
