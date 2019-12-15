package org.virtuex.gateway.cache;

import org.virtuex.gateway.model.PathInfo;
import org.virtuex.gateway.utils.AclHelper;
import org.virtuex.gateway.utils.JsonUtil;
import org.virtuex.gateway.utils.PathPatternUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description:用来加载接口信息的缓存
 * @date 2019/12/4 15:19
 */
@Slf4j
public class PathInfoCache {

    private static PathInfoCache INSTANCE;
    private static final String DEFAULT_PATH_VALUE_FILE = "path_info.json";

    private List<PathInfo> pathsList = new ArrayList<>();


    private PathInfoCache() {
    }

    public static PathInfoCache getInstance() {
        if (INSTANCE == null) {
            syncInit();
        }
        return INSTANCE;
    }

    private static synchronized void syncInit() {
        if (INSTANCE == null) {
            INSTANCE =  new PathInfoCache();
        }
    }

    public void load(){
        ClassPathResource classPathResource = new ClassPathResource(DEFAULT_PATH_VALUE_FILE);
        try {
            pathsList = JsonUtil.jsonToList(classPathResource.getFile(), PathInfo.class);
            log.info("接口权限信息加载完成");
        } catch (Exception e) {
            log.error("接口权限信息加载失败！原因:{}",e.getMessage(),e);
        }
    }

    public void reload(){
        pathsList.clear();
        load();
    }

    /**
     * 根据method和path即可确定接口
     * @param method
     * @param path
     */
    public boolean checkPath(String method,String path ,int aclValue){
        for(PathInfo pathInfo:pathsList){
            boolean methodIsRight = pathInfo.getHttpMethod().equals(method);
            boolean pathIsRight = StringUtils.isNoneBlank(PathPatternUtil.getMatchingPatterns(pathInfo.getPath(), path));
            //如果请求路径或者方法不满足，就没必要继续判断
            if(!(methodIsRight && pathIsRight)){
                continue;
            }
            //如果请求路径正确，判断下权限值
            boolean hasRights = AclHelper.testRights(aclValue, pathInfo.getPathId());
            if (hasRights) {
                return Boolean.TRUE;
            }
        }
       return false;
    }
}
