package org.virtuex.gateway.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description:
 * @date 2019/12/4 15:19
 */
public class PathInfo {
    @JsonProperty(value = "path_id")
    private int pathId;
    @JsonProperty(value = "http_method")
    private String httpMethod;
    @JsonProperty(value = "path")
    private String path;


    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
