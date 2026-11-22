package com.pokemon.api.PokemonApi.dto;

import java.util.List;

public record PokemonDetalhes(
        int id,
        String name,
        int height,
        int weight,
        int order,
        Pokemon.Sprites sprites,
        List<HabilidadeResponse> habilidades

) {
}
