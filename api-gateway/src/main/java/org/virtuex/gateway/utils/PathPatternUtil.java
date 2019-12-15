package org.virtuex.gateway.utils;

import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description: 用于校验请求路径与定义的路径规则是否匹配的工具类，如：
 * 请求为/admins/1，pattern为/admins/{id}。通过这个工具类可以校验是否匹配，用作针对单个接口的鉴权
 * @date 2019/10/12 10:32
 */
public class PathPatternUtil {
    private static AntPathMatcher pathMatcher = new AntPathMatcher();

    public static String getMatchingPatterns(String patternPath, String lookupPath) {
        String match = getMatchingPattern(patternPath, lookupPath);
        return match;
    }

    private static String getMatchingPattern(String patternPath, String lookupPath) {
        if (patternPath.equals(lookupPath)) {
            return patternPath;
        }
        if (pathMatcher.match(patternPath, lookupPath)) {
            return patternPath;
        }

        if (!patternPath.endsWith("/") && pathMatcher.match(patternPath + "/", lookupPath)) {
            return patternPath + "/";
        }
        return null;
    }
}
