/*
 * @author Zhanghh
 * @date 2019/4/13
 */
package com.nebula.mooc.core.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TokenUtil {

    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取经过md5散列后的token值
     *
     * @param sessionId 传入sessionId
     * @return 返回生成的token
     */
    public static String generateToken(String sessionId) throws Exception {
        if (sessionId == null) return null;
        sessionId += System.currentTimeMillis();
        byte[] md5 = md.digest(sessionId.getBytes());
        // TO-DO 乱码无法设置Cookie
        return new String(md5, StandardCharsets.UTF_8);
    }
}
