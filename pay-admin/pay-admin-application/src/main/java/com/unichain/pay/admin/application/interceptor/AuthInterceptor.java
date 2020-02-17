package com.unichain.pay.admin.application.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.unichain.framework.common.ResponseData;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Param
 * @return
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    public final static String TOKEN = "Token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 从方法处理器中获取出要调用的方法
            Method method = handlerMethod.getMethod();
            // 获取出方法上的Access注解
//            Access access = method.getAnnotation(Access.class);
//            if (access == null || !access.value()) {
//                return true;
//            }

            try {
                String token = request.getHeader(TOKEN);

//                if(tokenClient.verify(token, token)){
//                    return true;
//                } else {
//                    return false;
//                }
                return true;
            } catch (Exception e) {
                response.reset();
                response.setContentType("application/json;charset=UTF-8");
                response.addHeader(TOKEN, "-1");
                String outJson = JSONObject.toJSONString(ResponseData.ok(e.getMessage()));
                ServletOutputStream servletOutputStream = response.getOutputStream();
                servletOutputStream.write(outJson.getBytes(StandardCharsets.UTF_8));
                servletOutputStream.flush();
                servletOutputStream.close();
                return false;
            }
        }
        return true;
    }
}
