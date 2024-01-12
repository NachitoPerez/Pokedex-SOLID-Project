package com.example.pokedex.models.PokemonModels;

/**
 * PokemonSQLITE is the entity we'll be using to represent the Pokemon information we get from the SQLITE file disposed by the user
 *
 * @author Ignacio Pérez
 *
 */
public class PokemonSQLITE extends Pokemon {
    private final String description;

    public PokemonSQLITE(int pokemonId, String name, String description, float weight, float height){
        super(pokemonId, name, weight, height);
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
