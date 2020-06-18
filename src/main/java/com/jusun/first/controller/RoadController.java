package com.jusun.first.controller;

import com.jusun.first.domins.RoadDTO;
import com.jusun.first.services.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/road")
public class RoadController {
    @Autowired
    RoadService roadService;

    @GetMapping("/list")
    public List<RoadDTO> getList() {
        return roadService.retriverAll();
    }
}
