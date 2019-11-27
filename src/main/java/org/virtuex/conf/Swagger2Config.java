package org.virtuex.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author virtuex
 * @email xuda.it@outlook.com
 * @Description:
 * @date 2019/11/6 10:37
 */
@Configuration
public class Swagger2Config {

    @Bean
    public Docket adminsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.virtuex"))
                .build()
                .groupName("user_api")
                ;
    }

    @Bean
    public Docket authApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/auth/**"))
                .build()
                .groupName("auth_api")
                ;
    }

    @Bean
    public Docket oauthApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/oauth/**"))
                .build()
                .groupName("oauth_api")
                ;
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("xxxx系统接口说明")
               .description("测试使用")
                .version("v1.0")
                .build();
    }
}
