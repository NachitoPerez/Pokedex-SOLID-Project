package com.example.pokedex.models.PokemonModels;

/**
 * Pokemon is the entity we'll be using to represent the Pokemon information we get from the API
 *
 * @author Ignacio Pérez
 *
 */
public class Pokemon {
    private final int id;
    private final String name;
    private final float weight;
    private final float height;

    public Pokemon(int pokemonId, String name, float weight, float height){
        this.id = pokemonId;
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }
}
