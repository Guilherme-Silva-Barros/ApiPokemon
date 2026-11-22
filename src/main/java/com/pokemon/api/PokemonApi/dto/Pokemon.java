package com.pokemon.api.PokemonApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Pokemon(
        int id,
        String name,
        @JsonProperty("base_experience") Integer baseExperience,
        int height,
        int weight,
        int order,
        List<AbilitiesSlot> abilities,
        Sprites sprites
) {
    public record AbilitiesSlot(
            int slot,
            @JsonProperty("is_hidden") boolean isHidden,
            AbilityInfo ability
    ) {}
    public record AbilityInfo(
            String name,
            String url)
    {}
    public record Sprites(
            @JsonProperty("front_default")String frontDefault){}

}
