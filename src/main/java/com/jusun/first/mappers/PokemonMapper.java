package com.jusun.first.mappers;

import com.jusun.first.domins.PokemonDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonMapper {
    public List<PokemonDTO> selectAll();
}
