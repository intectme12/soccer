package com.jihwan.soccer.sign;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sign")
public class SignController {

    @GetMapping("/moveUserSignAgree")
    public String moveUserSignAgree(){

        return "/sign/user-sign-agree";
    }

    @PostMapping("/moveUserSign")
    public String moveUserSign(){

        return "/sign/user-sign";
    }

    @PostMapping("/checkUserId")
    @ResponseBody
    public String checkUserId(@RequestBody String requestData){

        System.out.println(requestData);

        return "true";
    }

    @PostMapping("/checkUserNik")
    @ResponseBody
    public String checkUserNik(@RequestBody String requestData){

        System.out.println(requestData);

        return "true";
    }
}
