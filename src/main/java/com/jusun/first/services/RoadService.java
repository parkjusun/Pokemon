package com.jusun.first.services;

import com.jusun.first.domins.RoadDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoadService {
    public List<RoadDTO> retriverAll();
}
