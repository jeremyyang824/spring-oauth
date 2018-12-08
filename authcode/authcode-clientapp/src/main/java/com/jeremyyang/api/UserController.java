package com.jeremyyang.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

    // 资源API
    @RequestMapping("/api/userinfo")
    public ResponseEntity<UserInfo> getUserInfo() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String principal = authentication.getPrincipal().toString();

        UserInfo userInfo = new UserInfo();
        userInfo.setName(principal);
        userInfo.setEmail(principal + "@fantasy.com");

        return ResponseEntity.ok(userInfo);
    }

}
