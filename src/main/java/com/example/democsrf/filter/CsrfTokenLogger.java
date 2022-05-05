package com.example.democsrf.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;

import javax.servlet.*;
import java.io.IOException;

public class CsrfTokenLogger implements Filter {


    private final Logger logger= LoggerFactory.getLogger(CsrfTokenLogger.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Object object=request.getAttribute("_csrf");
        CsrfToken csrfToken=(CsrfToken) object;
        logger.info("CSRF TOKEN "+ csrfToken.getToken());
        chain.doFilter(request,response);

    }
}
