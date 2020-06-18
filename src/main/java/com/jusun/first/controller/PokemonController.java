package com.jusun.first.controller;

import com.jusun.first.domins.PokemonDTO;
import com.jusun.first.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired PokemonService pokemonService;

    @GetMapping("/list")
    public List<PokemonDTO> getList(){
        return pokemonService.retriverAll();
    }
}
