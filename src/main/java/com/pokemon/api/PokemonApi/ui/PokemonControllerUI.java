package com.pokemon.api.PokemonApi.ui;

import com.pokemon.api.PokemonApi.service.PokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PokemonControllerUI {

    private final PokemonService pokemonService;
    public PokemonControllerUI(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) String termo,  Model model) {
        if(termo != null && !termo.isBlank()){
            model.addAttribute("termo", termo);
            try{
                model.addAttribute("pokemon", pokemonService.buscarDetalhes(termo.trim()));
            }catch(Exception e){
                model.addAttribute("Erro", e.getMessage());
            }
        }
        return "index";
    }
}
