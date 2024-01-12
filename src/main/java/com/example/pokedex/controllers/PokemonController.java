package com.example.pokedex.controllers;

import com.example.pokedex.models.AppOptions;
import com.example.pokedex.models.PokemonModels.Pokemon;
import com.example.pokedex.models.PokemonModels.PokemonSQLITE;
import com.example.pokedex.services.DataBaseServices.PokemonAPIService;
import com.example.pokedex.services.DataBaseServices.SQLLiteService;

public class PokemonController {
    public PokemonSQLITE getPokemonById(int pokemonId, String databaseFilePath){
        return new SQLLiteService().getPokemonInformationById(pokemonId, databaseFilePath);
    }

    public Pokemon getPokemonById(int pokemonId){
        return new PokemonAPIService().getPokemonInformationById(pokemonId);
    }
}
