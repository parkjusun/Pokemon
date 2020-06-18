package com.jusun.first.mappers;

import com.jusun.first.domins.RoadDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoadMapper {
    public List<RoadDTO> selectAll();
}
