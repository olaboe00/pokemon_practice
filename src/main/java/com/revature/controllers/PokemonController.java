package com.revature.controllers;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Pokemon;
import com.revature.services.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
  
  PokemonService pokemonService;
    
  @Inject
  public PokemonController(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }

  @GetMapping("/{id:[0-9]+}")
  public Pokemon findById(@PathVariable int id) {
    return null;
  }
  
}
