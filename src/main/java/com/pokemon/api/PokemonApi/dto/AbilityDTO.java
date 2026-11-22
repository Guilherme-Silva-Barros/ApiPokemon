package com.pokemon.api.PokemonApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AbilityDTO(
        int id,
        String name,
        @JsonProperty("effect_entries") List<EffectEntries> effectEntries
) {

    public record EffectEntries(
            String effect,
            @JsonProperty("short_effect") String shortEffect,
            Language language
    ){}
    public record Language(
            String name){}

}
