package org.virtuex.gateway.runner;

import org.virtuex.gateway.cache.PathInfoCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description:
 * @date 2019/12/4 15:26
 */
@Component
@Slf4j
public class PathInfoIniitRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        PathInfoCache.getInstance().load();
    }
}
