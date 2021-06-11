package com.demo.java.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Author: zjhan
 * @Date: 2021/6/10 20:45
 * @Description:
 **/
public class JwtUtils {
    public static String sign(String account, String currentTimeMillis) {
        try {
            Date date = new Date(System.currentTimeMillis() + 100 * 1000);
            Algorithm algorithm = Algorithm.HMAC256("abcdtest");
            // 附带account帐号信息
            return JWT.create()
                    .withClaim("account", account)
                    .withClaim("currentTimeMillis", currentTimeMillis)
//                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getClaim(String token, String claim) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            // 只能输出String类型，如果是其他类型返回null
            return jwt.getClaim(claim).asString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean verify(String token) {
        try {
            // 帐号加JWT私钥解密
            String secret = getClaim(token, "account");
            System.out.println(secret);
            long curr = Long.parseLong(getClaim(token, "currentTimeMillis"));
            System.out.println(System.currentTimeMillis() - curr);
            Algorithm algorithm = Algorithm.HMAC256("abcdtest");
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(sign("test", "1000"));
        System.out.println(verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdXJyZW50VGltZU1pbGxpcyI6IjEwMDAiLCJhY2NvdW50IjoidGVzdCJ9.2gFUyaC0qFO3oVT8o4dHH6OWuoOMMFI81-eDWMRZBL8"));
    }
}
