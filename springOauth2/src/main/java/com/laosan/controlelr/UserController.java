package com.laosan.controlelr;

import io.jsonwebtoken.Jwts;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: laosan
 * Date: 2022/2/4
 * Time: 18:10
 * Describe:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication, HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = header.substring(header.lastIndexOf("bearer") + 7);
        
//        return authentication.getPrincipal();
        return Jwts.parser().setSigningKey("test_key".getBytes(StandardCharsets.UTF_8)).parseClaimsJwt(token).getBody();
    }
}
