package com.lzjtuimis.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
                                                  // '/*'的url表示任何访问都会执行该过滤器
@WebFilter(filterName = "SetCharacterEncodingFilter", urlPatterns = { "/*" },
        initParams = { @WebInitParam(name = "encoding", value = "utf-8") })
public class SetCharacterEncodingFilter implements Filter {
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        // 过滤器先执行的字符集编码
        this.encoding = config.getInitParameter("encoding");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //使用注解中提供的默认初始化参数
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }
}
