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
    /**
     * 生成token
     * @param account 账号
     * @param currentTimeMillis 当前时间
     * @return 生成token
     */
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

    /**
     * 获取token中claim的信息
     * @param token 需解析的token字符串
     * @param claim 查看token中claim的名称
     * @return token中claim的值
     */
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

    /**
     * 验证token是否有效
     * @param token 需要验证的token
     * @return
     */
    public static boolean verify(String token) {
        try {
            // 帐号加JWT私钥解密
            Algorithm algorithm = Algorithm.HMAC256("abcdtest");
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取token的失效时间
     * @param token token字符串
     * @return
     */
    public static Date getExpTime(String token) {
        return JWT.decode(token).getExpiresAt();
    }

    public static void main(String[] args) {
        System.out.println(sign("test", "1000"));
    }
}
