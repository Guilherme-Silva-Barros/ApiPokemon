package com.pokemon.api.PokemonApi.controller;

import com.pokemon.api.PokemonApi.dto.Pokemon;
import com.pokemon.api.PokemonApi.dto.PokemonDetalhes;
import com.pokemon.api.PokemonApi.dto.PokemonLista;
import com.pokemon.api.PokemonApi.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public PokemonLista listaPokemons(@RequestParam int limit, @RequestParam int offset){
        return pokemonService.getListPokemon(limit, offset);
    }
    @GetMapping("/{nameOrId}")
    public PokemonDetalhes getPokemonDetalhes(@PathVariable String nameOrId){
        return pokemonService.buscarDetalhes(nameOrId);
    }


}
