package com.pokemon.api.PokemonApi.service;

import com.pokemon.api.PokemonApi.client.PokeClient;
import com.pokemon.api.PokemonApi.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private final PokeClient pokeClient;
    public PokemonService(PokeClient pokeClient) {
        this.pokeClient = pokeClient;
    }

    public Pokemon getPokemon(String nameOrId){
        return pokeClient.buscarPorNome(nameOrId);
    }

    public PokemonLista getListPokemon(int limit, int offset){
        return pokeClient.listarPokemons(limit, offset);
    }
    private String descricao(AbilityDTO ability){
        return ability.effectEntries().stream()
                .filter(entry -> entry.language().name().equals("en"))
                .map(AbilityDTO.EffectEntries::shortEffect)
                .findFirst()
                .orElse("Descriçãoo indisponível");
    }

    public PokemonDetalhes buscarDetalhes(String nameOrId){
        Pokemon pokemon = pokeClient.buscarPorNome(nameOrId);
        List<HabilidadeResponse> habilidades = pokemon.abilities().stream()
                .map(slot -> {
                    String nome = slot.ability().name();
                    AbilityDTO ability = pokeClient.buscarHabilidade(nome);
                    return new HabilidadeResponse(nome, slot.isHidden(), descricao(ability));
                })
                .toList();
        return new PokemonDetalhes(pokemon.id(), pokemon.name(),pokemon.height(),pokemon.weight(), pokemon.order(), pokemon.sprites(), habilidades);
    }

}
