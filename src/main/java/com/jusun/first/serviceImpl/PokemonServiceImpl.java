package com.jusun.first.serviceImpl;



import com.jusun.first.domins.PokemonDTO;
import com.jusun.first.mappers.PokemonMapper;
import com.jusun.first.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    PokemonMapper poketmonMapper;

    @Override
    public List<PokemonDTO> retriverAll() {
        return poketmonMapper.selectAll();
    }
}
