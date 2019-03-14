package com.revature.tests.services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Pokemon;
import com.revature.repos.PokemonRepo;
import com.revature.services.PokemonService;

@RunWith(SpringRunner.class)
public class PokemonServiceTests {

  @Mock
  PokemonRepo mockPokemonRepo;
  
  @InjectMocks
  PokemonService pokemonService;
  
  @Test
  public void testFindByValidId() {
    int targetId = 5;
    Pokemon expected = new Pokemon();
    expected.setId(targetId);
    
    when(mockPokemonRepo.findById(targetId)).thenReturn(expected);
    
    Pokemon found = pokemonService.findById(targetId);
    
    assertNotNull("Pokemon should be not null", found);
    assertThat("Pokemon found should be the expected pokemon", found, is(expected));
  }
  
  @Test
  public void testFindByInvalidId() {
    int targetId = -5;
    
    when(mockPokemonRepo.findById(targetId)).thenReturn(null);
    
    HttpClientErrorException ex = null;
    Pokemon found = null;
    try {
      found = pokemonService.findById(targetId);
      fail("Exception should have been thrown");
    } catch (HttpClientErrorException e) {
      ex = e;
    }
    
    assertNull("Requesting a pokemon with a negative id should return null", found);
    assertNotNull("Requesting a pokemon with a negative id should throw a HttpClientErrorException", ex);
    assertThat("HttpClientErrorException should have status 400", ex.getStatusCode(), is(HttpStatus.BAD_REQUEST));
  }
  
  @Test
  public void testFindByIdNotFound() {
    int targetId = 5;
    
    when(mockPokemonRepo.findById(targetId)).thenReturn(null);
    
    HttpClientErrorException ex = null;
    Pokemon found = null;
    try {
      found = pokemonService.findById(targetId);
      fail("Exception should have been thrown");
    } catch (HttpClientErrorException e) {
      ex = e;
    }
    
    assertNull("Requesting a pokemon thats not in the database should return null", found);
    assertNotNull("Requesting a non-existent pokemon should throw a HttpClientErrorException", ex);
    assertThat("HttpClientErrorException should have status 404", ex.getStatusCode(), is(HttpStatus.NOT_FOUND));
  }
  
}
