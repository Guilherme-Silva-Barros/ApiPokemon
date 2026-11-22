package com.pokemon.api.PokemonApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class PokemonHandlerException {

    @ExceptionHandler(PokemonNaoEncontradoException.class)
    ProblemDetail pokemonNaoEncontrado(PokemonNaoEncontradoException ex){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(ResourceAccessException.class)
    ProblemDetail erroComApi(ResourceAccessException ex){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_GATEWAY, ex.getMessage());
    }

}
