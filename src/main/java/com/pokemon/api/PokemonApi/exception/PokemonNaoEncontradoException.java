package com.pokemon.api.PokemonApi.exception;

public class PokemonNaoEncontradoException extends RuntimeException {
    public PokemonNaoEncontradoException(String nameOrId) {
        super("O Pokemon ou Id: "+nameOrId+" não foi encontrado");
    }
}
