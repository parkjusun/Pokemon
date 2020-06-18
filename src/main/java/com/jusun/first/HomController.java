package com.jusun.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomController {
    @GetMapping("/")
    public String home(){

        return "안녕 인텔리전트";
    }
}
