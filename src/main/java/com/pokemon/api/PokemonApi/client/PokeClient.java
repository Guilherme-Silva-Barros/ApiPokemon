package com.pokemon.api.PokemonApi.client;

import com.pokemon.api.PokemonApi.dto.AbilityDTO;
import com.pokemon.api.PokemonApi.dto.Pokemon;
import com.pokemon.api.PokemonApi.dto.PokemonLista;
import com.pokemon.api.PokemonApi.exception.PokemonNaoEncontradoException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PokeClient {

    private final RestClient restClient;
    public PokeClient(RestClient restClient) {
        this.restClient = restClient;
    }
    @Cacheable("pokemon")
    public PokemonLista listarPokemons(int limit, int offset){
        return restClient.get()
                .uri("pokemon?limit={1}&offset={0}", limit, offset)
                .retrieve()
                .body(PokemonLista.class);
    }

    public Pokemon buscarPorNome(String nameOrId){
        return restClient.get()
                .uri("pokemon/{v}", nameOrId.toLowerCase())
                .retrieve()
                .onStatus(status -> status.value()==404,(request, response) ->
                {throw new PokemonNaoEncontradoException(nameOrId);})
                .body(Pokemon.class);
    }
    @Cacheable("habilidades")
    public AbilityDTO buscarHabilidade(String nome){
        return restClient.get()
                .uri("/ability/{name}",nome)
                .retrieve()
                .body(AbilityDTO.class);
    }
}
