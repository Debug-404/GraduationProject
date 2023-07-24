package com.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    /**
     * token 过期时间, 单位: 毫秒. 这个值表示 7 天
     */
    private static final long TOKEN_EXPIRED_TIME = 7 * 24 * 60 * 60 * 1000;
    /**
     * jwt 加密解密密钥
     */
    private static final String KEY = "adfna^^DKSF(_)*";

    /**
     * 创建token
     */
    public static String createToken(Map<String, String> claimMap) {
        // 当前时间戳加上设定的毫秒数（1秒 == 1000毫秒）
        Date expiration = new Date(System.currentTimeMillis() + TOKEN_EXPIRED_TIME * 1000);
        // 设置JWT头部
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        JWTCreator.Builder builder = JWT.create();

        //创建payload
        claimMap.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        // 添加头部，可省略保持默认，默认即map中的键值对
        return builder.withHeader(map)
                // 设置过期时间
                .withExpiresAt(expiration)
                // 设置签名解码算法
                .sign(Algorithm.HMAC256(KEY));
    }

    /**
     * 验证jwt
     */
    public static DecodedJWT verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(KEY)).build().verify(token);
    }

}
