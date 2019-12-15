package org.virtuex.gateway.utils;


import io.jsonwebtoken.lang.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description:
 * @date 2019/12/4 14:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PathPatternUtilTest {
    @Test
    public void testPattern(){
        //正常流测试
        Assert.notNull(PathPatternUtil.getMatchingPatterns("/admins","/admins"));
        Assert.notNull(PathPatternUtil.getMatchingPatterns("/admins/{id}","/admins/1"));
        Assert.notNull(PathPatternUtil.getMatchingPatterns("/admins/{id}","/admins/{abcdada}"));
        Assert.notNull(PathPatternUtil.getMatchingPatterns("/admins/{test}/files","/admins/aaa/files"));
        Assert.notNull(PathPatternUtil.getMatchingPatterns("/admins/{test}/files","/admins/1/files"));
        Assert.notNull(PathPatternUtil.getMatchingPatterns("/admins/{id}/files","/admins/1/files"));
        //异常流测试
        Assert.isNull(PathPatternUtil.getMatchingPatterns("/admins","/admins1"));
        Assert.isNull(PathPatternUtil.getMatchingPatterns("/admins","/admins1"));
        Assert.isNull(PathPatternUtil.getMatchingPatterns("/admins/{id}","/admins/test/aaa"));
        Assert.isNull(PathPatternUtil.getMatchingPatterns("/admins/{id}","/admins/test/aaa"));
    }

}
