package com.guodong.eduservice.controller;

import com.guodong.commonutils.R;
import jdk.nashorn.internal.parser.Token;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("eduservice/user")
@CrossOrigin
public class EduLoginController {

    @PostMapping("/login")
    public R login(){
        return R.ok().data("token", "admin");
    }

    @GetMapping("/info")
    public R getUserInfo() {
        HashMap<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", "admin");
        userInfo.put("roles", "[admin]");
        userInfo.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return R.ok().data(userInfo);
    }
}
