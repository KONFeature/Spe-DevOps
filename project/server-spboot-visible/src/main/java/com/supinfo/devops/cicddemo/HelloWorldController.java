package com.supinfo.devops.cicddemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String index() {
        return "HelloWorld fron CiCd by Quentin Nivelais (idBosster : 280797)";
    }

}
