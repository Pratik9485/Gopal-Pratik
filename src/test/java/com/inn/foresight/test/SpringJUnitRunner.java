package com.inn.foresight.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import com.inn.commons.configuration.ConfigUtils;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringJUnitRunner {

  @LocalServerPort
  private int port;

  private static final String PATH = "http://localhost:";

  static {
    ConfigUtils.setPropertiesFilePath("application.properties", "config.properties");
  }

  protected String baseUrl() {
    String contextPath = ConfigUtils.getString("server.servlet.context-path", "");
    String servletPath = ConfigUtils.getString("spring.mvc.servlet.path", "");
    
    System.out.println("SpringJUnitRunner baseUrl is " + (PATH + port + contextPath + servletPath));
    return PATH + port + contextPath + servletPath;
  }

}
