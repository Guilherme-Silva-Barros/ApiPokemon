package com.pokemon.api.PokemonApi.dto;

import java.util.List;

public record HabilidadeResponse(
        String nome,
        boolean oculta,
        String descricao
) {
}
