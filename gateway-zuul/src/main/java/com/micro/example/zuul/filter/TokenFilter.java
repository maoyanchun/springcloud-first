package com.micro.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc:假设有这样一个场景，因为服务网关应对的是外部的所有请求，为了避免产生安全隐患，我们需要对请求做一定的限制，比如请求中含有Token便让请求继续往下走，如果请求不带Token就直接返回并给出提示
 * 实现自定义filter，需要实现ZuulFilter类
 * Created by mycge on 2018/4/25.
 */
public class TokenFilter extends ZuulFilter{
    @Override
    public String filterType() {//定义filter的类型，有pre, route, post, error
        return "pre";
    }

    @Override
    public int filterOrder() {//定义filter的顺序，数字越小表示顺序越高，越先执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {//表示是否需要执行该filter，true表示执行，false表示不执行
        return true; //表示需要过滤
    }

    @Override
    public Object run() {//filter需要执行的具体操作
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String token = request.getParameter("token");

        if(StringUtils.isNotBlank(token)){
            requestContext.setSendZuulResponse(true);//对请求进行路由
            requestContext.setResponseStatusCode(200);
            requestContext.set("isSuccess", true);
        }else {
            requestContext.setSendZuulResponse(false);//不对其进行路由
            requestContext.setResponseStatusCode(400);
            requestContext.setResponseBody("Token is Empty");
            requestContext.set("isSuccess", false);
        }
        return null;
    }
}
