package com.example.pokedex.models;

import com.example.pokedex.models.PokemonModels.Pokemon;
import com.example.pokedex.models.PokemonModels.PokemonSQLITE;
import com.example.pokedex.views.PokemonAPIView;
import com.example.pokedex.views.PokemonSQLITEView;

/**
 * PokemonViewBuilder is the entity we'll be using to create the Pokemon View, according to the information we have
 *
 * @author Ignacio Pérez
 *
 */
public class PokemonViewBuilder {
    public static PokemonSQLITEView createPokemonView(PokemonSQLITE pokemon) {
        return new PokemonSQLITEView(pokemon);
    }

    public static PokemonAPIView createPokemonView(Pokemon pokemon) {
        return new PokemonAPIView(pokemon);
    }
}
