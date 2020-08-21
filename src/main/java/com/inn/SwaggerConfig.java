package com.inn;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ImplicitGrantBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.LoginEndpoint;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.inn")).build()
        .securitySchemes(Arrays.asList(oAuthSecurityScheme()));
  }
  
//Describe your apis
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger Sample APIs")
				.description("This page lists all the rest apis for Swagger Sample App.").version("1.0-SNAPSHOT")
				.build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	private SecurityScheme oAuthSecurityScheme() {

		GrantType grantType = new ImplicitGrantBuilder().loginEndpoint(new LoginEndpoint("http://petstore.swagger.io/oauth/dialog"))
				.tokenName("bearer").build();

		OAuth oauth = new OAuth("default", Arrays.asList(scopes()), Arrays.asList(grantType));

		return oauth;
	}

	private AuthorizationScope[] scopes() {

		//PermissionDao permissionDao = ApplicationContextProvider.getApplicationContext().getBean(PermissionDao.class);

		//List<PermissionDataWrapper> permissionDataWrapper = permissionDao.getAllPermissionsData();
		//System.out.println("Permission Data Size : " + permissionDataWrapper.size());
      
		AuthorizationScope[] scopes = new AuthorizationScope[16];
		AuthorizationScope scope0= new AuthorizationScope("NETWORK_TREE_PERMISSION","NETWORK_TREE_PERMISSION" );
		AuthorizationScope scope1= new AuthorizationScope("GOLDEN_AUDIT_PERMISSION","GOLDEN_AUDIT_PERMISSION" );
		AuthorizationScope scope2= new AuthorizationScope("GOLDEN_PARAMETER_VIEW_PERMISSION","GOLDEN_PARAMETER_VIEW_PERMISSION" );
		AuthorizationScope scope3= new AuthorizationScope("GOLDEN_PARAMETER_EDIT_PERMISSION","GOLDEN_PARAMETER_EDIT_PERMISSION" );

		AuthorizationScope scope4= new AuthorizationScope("CM_READ_DATA_PERMISSION","CM_READ_DATA_PERMISSION" );
		AuthorizationScope scope5= new AuthorizationScope("CM_WRITE_DATA_PERMISSION","CM_WRITE_DATA_PERMISSION" );
		AuthorizationScope scope6= new AuthorizationScope("CM_CREATE_DATA_PERMISSION","CM_CREATE_DATA_PERMISSION" );
		AuthorizationScope scope7= new AuthorizationScope("CM_UPDATE_DATA_PERMISSION","CM_UPDATE_DATA_PERMISSION" );
		AuthorizationScope scope8= new AuthorizationScope("CM_UPLOAD_DATA_PERMISSION","CM_UPLOAD_DATA_PERMISSION" );
		AuthorizationScope scope9= new AuthorizationScope("CM_DELETE_DATA_PERMISSION","CM_DELETE_DATA_PERMISSION" );
		AuthorizationScope scope10= new AuthorizationScope("CM_DOWNLOAD_DATA_PERMISSION","CM_DOWNLOAD_DATA_PERMISSION" );

		
		AuthorizationScope scope11= new AuthorizationScope("GOLDEN_PARAMETER_CREATE_PERMISSION","GOLDEN_PARAMETER_CREATE_PERMISSION" );
		AuthorizationScope scope12= new AuthorizationScope("TELECOM_LIBRARY_VIEW_PERMISSION","TELECOM_LIBRARY_VIEW_PERMISSION" );
		AuthorizationScope scope13= new AuthorizationScope("TELECOM_LIBRARY_EDIT_PERMISSION","TELECOM_LIBRARY_EDIT_PERMISSION" );
		AuthorizationScope scope14= new AuthorizationScope("TELECOM_LIBRARY_CREATE_PERMISSION","TELECOM_LIBRARY_CREATE_PERMISSION" );
		AuthorizationScope scope15= new AuthorizationScope("TELECOM_LIBRARY_DELETE_PERMISSION","TELECOM_LIBRARY_DELETE_PERMISSION" );

		
		scopes[0]=scope0;
		scopes[1]=scope1;
		scopes[2]=scope2;
		scopes[3]=scope3;
		scopes[4]=scope4;
		scopes[5]=scope5;
		scopes[6]=scope6;
		scopes[7]=scope7;
		scopes[8]=scope8;
		scopes[9]=scope9;
		scopes[10]=scope10;
		scopes[11]=scope11;
		scopes[12]=scope12;
		scopes[13]=scope13;
		scopes[14]=scope14;
		scopes[15]=scope15;
	
		return scopes;
	}



}
