package com.exception.interceptor;

import com.alibaba.fastjson2.JSON;
import com.annotation.PassToken;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.utils.JwtUtils;
import com.utils.Result;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器 用于验证token
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) return true;

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否通过有PassToken注解
        if (method.isAnnotationPresent(PassToken.class)) {
            //如果有则跳过认证检查
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        Result result = new Result();
        // 获取请求头中令牌
        String token = request.getHeader("token");
        try {
            // 验证令牌
            JwtUtils.verifyToken(token);
            // 验证成功，放行请求
            return true;
        } catch (SignatureVerificationException e) {
            result.setMessage("无效签名!");
        } catch (TokenExpiredException e) {
            result.setMessage("token过期!");
        } catch (Exception e) {
            result.setMessage("token无效!");
        }

        result.setCode(Result.Unauthorized_CODE);
        String s = JSON.toJSONString(result);
        // 返回json数据
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);
        return false;
    }

}
