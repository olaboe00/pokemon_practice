package com.revature.services;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Pokemon;
import com.revature.repos.PokemonRepo;

@Service
public class PokemonService {
  
  PokemonRepo pokemonRepo;
  
  @Inject
  public PokemonService(PokemonRepo pokemonRepo) {
    super();
    this.pokemonRepo = pokemonRepo;
  }

  public Pokemon findById(int id) {
    if (id <= 0) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Id should be positive");
    Pokemon pokemon = pokemonRepo.findById(id);
    if (pokemon == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Pokemon not found");
    return pokemon;
  }
  
}
