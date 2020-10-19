package com.example.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.RequiredArgsConstructor;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("example.api.control"))
                .paths(PathSelectors.any())
                .build();

    }
}


//@RequiredArgsConstructor
//@Configuration
//@EnableSwagger2
//@PropertySource("classpath:application.properties")
//public class SwaggerConfig {
//	
//	@Value("${spring.security.oauth2.client.registration.basic.client-id}")
//    private String clientId;
//
//    @Value("${spring.security.oauth2.client.registration.basic.client-secret}")
//    private String clientSecret;
//    
//    @Bean
//    public Docket api() {
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                    .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
//                    .paths(PathSelectors.any())
//                    .build()
//                .pathMapping("/")
//                .securitySchemes(Arrays.asList(apiKey()))
//                .securityContexts(Arrays.asList(securityContext()))
//                .apiInfo(apiInfo());
//    }
//    
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("REST API Document")
//                .description("description for api")
//                .termsOfServiceUrl("localhost")
//                .version("1.0")
//                .build();
//    }
//    
//    private ApiKey apiKey() {
//        return new ApiKey("apiKey", "Authorization", "header");
//    }
//    
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .build();
//    }
//    
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList(new SecurityReference("apiKey", authorizationScopes));
//    }
//    
//    @Bean
//    public SecurityConfiguration security() {
//        return SecurityConfigurationBuilder.builder()
//                .clientId(clientId)
//                .clientSecret(clientSecret)
//                .realm("realm")
//                .appName("demo")
//                .scopeSeparator(",")
//                .additionalQueryStringParams(null)
//                .useBasicAuthenticationWithAccessCodeGrant(false)
//                .build();
//    }
//}
