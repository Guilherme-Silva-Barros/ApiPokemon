package com.pokemon.api.PokemonApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokemonLista(
        int cout,
        String next,
        String previous,
        List<PokemonRef> results

) {
    public record PokemonRef(String name, String url){}
}
