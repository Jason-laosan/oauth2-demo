package com.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @author: laosan
 * Date: 2022/2/5
 * Time: 18:15
 * Describe:
 */
@SpringBootApplication
//开启单点登录
@EnableOAuth2Sso
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
