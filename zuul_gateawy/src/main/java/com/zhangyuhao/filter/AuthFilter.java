package com.zhangyuhao.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        StringBuffer requestURL = request.getRequestURL();

        System.out.println("requestContext======"+requestContext);
        System.out.println("request======"+request);
        System.out.println("requestURL======"+requestURL);

        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        System.out.println("run"+request.getRequestURI());
        //是否授权
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            //false不会路由到后端的服务
            requestContext.setSendZuulResponse(false);
            //设置状态码401代表未授权
            requestContext.setResponseStatusCode(401);
            HttpServletResponse response = requestContext.getResponse();
            response.setContentType("application/json;charset=utf-8");
            try {
                response.getWriter().write("{\"code:\":401,\"msg:\":\"未授权\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
