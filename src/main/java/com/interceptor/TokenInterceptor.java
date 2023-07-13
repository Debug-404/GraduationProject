package com.interceptor;

import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.utils.JwtUtils;
import com.utils.Result;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Result result = new Result();
        //获取请求头中令牌
        String token = request.getHeader("token");
        try {
            //验证令牌
            JwtUtils.verifyToken(token);
            //验证成功，放行请求
            return true;
        } catch (SignatureVerificationException e) {
            result.setMessage("无效签名!");
        } catch (TokenExpiredException e) {
            result.setMessage("token过期!");
        } catch (Exception e) {
            result.setMessage("token无效!");
        }

        result.setCode(Result.Unauthorized_CODE);
        //将map转为json
        String s = JSON.toJSONString(result);
        // 相应json数据
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);
        return false;
    }

}
