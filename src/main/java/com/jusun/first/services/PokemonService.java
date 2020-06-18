package com.jusun.first.services;

import com.jusun.first.domins.PokemonDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PokemonService {
    public List<PokemonDTO> retriverAll();
}
