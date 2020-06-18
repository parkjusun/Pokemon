package com.jusun.first.serviceImpl;

import com.jusun.first.domins.RoadDTO;
import com.jusun.first.mappers.RoadMapper;
import com.jusun.first.services.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoadServiceImpl implements RoadService {
    @Autowired
    RoadMapper roadMapper;

    @Override
    public List<RoadDTO> retriverAll() {
        return roadMapper.selectAll();
    }
}
