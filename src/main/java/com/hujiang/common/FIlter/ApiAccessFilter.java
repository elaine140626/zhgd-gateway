package com.hujiang.common.FIlter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import java.util.logging.Logger;

@WebFilter(filterName = "ApiAccessFilter", urlPatterns = "/*")
public class ApiAccessFilter implements Filter {
    private Logger logger = Logger.getLogger(ApiAccessFilter.class.getName());
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

//        Long requestId = IdGenUtils.nextIdByMem(); // 请求ID，这个是我业务中的id，大家可自行决定是否需要
        long start = System.currentTimeMillis(); // 请求进入时间


        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("接口："+request.getRequestURI()+"=============时间："+(System.currentTimeMillis() - start));

    }

    @Override
    public void destroy() {

    }
}
