package com.ms.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfiguration {

    /*引入Knife4j提供的扩展类*/
    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public SwaggerConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean
    public Docket defaultApi2() {
        String groupName = "2.X版本";
        //配置请求头
        //List<Parameter> pars = new ArrayList<>();
        //ParameterBuilder parameterBuilder = new ParameterBuilder();
        //parameterBuilder.name("Content-Type")
        //        .description("连接类型")
        //        .defaultValue("application/json")
        //        .modelRef(new ModelRef("string"))
        //        .parameterType("header")
        //        .required(false)
        //        .build();
        //pars.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .host("https://www.baidu.com")
                .apiInfo(apiInfo())
                //.globalOperationParameters(pars)
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ms"))
                .paths(PathSelectors.any())
                .build();
                //赋予插件体系,接口签名
                //.extensions(openApiExtensionResolver.buildExtensions(groupName));
    }

    @Bean
    public Docket defaultApi3() {
        String groupName = "3.X1版本";
        return new Docket(DocumentationType.SWAGGER_2)
                .host("https://www.baidu.com")
                .apiInfo(apiInfo())
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ms"))
                .paths(PathSelectors.any())
                .build();
                //赋予插件体系,接口签名
                //.extensions(openApiExtensionResolver.buildExtensions(groupName));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ms test")
                .description("api des")
                .build();
    }
}
