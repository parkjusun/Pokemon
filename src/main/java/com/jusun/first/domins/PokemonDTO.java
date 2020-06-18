package com.jusun.first.domins;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PokemonDTO {
   public String
           name,
           stamina,
           atk,
           def,
           captureRate,
           fleeRate,
           spawnChance,
           prim,
           secondary,
           cp,
           url;
}
