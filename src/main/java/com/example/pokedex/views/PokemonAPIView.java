package com.example.pokedex.views;

import com.example.pokedex.models.PokemonModels.Pokemon;
import com.example.pokedex.utilities.MultipleFormatGenerator;

/**
 * PokemonAPIView is the entity we'll be using to show the Pokemon information retrieved using the API
 *
 * @author Ignacio Pérez
 *
 */

public class PokemonAPIView implements MultipleFormatGenerator {

    private final Pokemon pokemon;

    public PokemonAPIView(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    @Override
    public String generateHTML() {
        return "<h1>" + pokemon.getName() + "</h1>\n" +
                "<ul>\n" +
                "<li>Id : " + pokemon.getId() + "</li>\n" +
                "<li>Taille : " + pokemon.getHeight() + "</li>\n" +
                "<li>Poids : " + pokemon.getWeight() + "</li>\n" +
                "</ul>";
    }

    @Override
    public String generateCSV() {
        return "Id;Name;Height;Weight;\n" +
                pokemon.getId() + ";\"" + pokemon.getName() + "\";" + pokemon.getHeight() + ";" + pokemon.getWeight() + "\"\n";
    }

    @Override
    public String generateHumanReadableText() {
        return "===============================\n" +
                "Pokémon #" + pokemon.getId() + "\n" +
                "Nom : " + pokemon.getName() + "\n" +
                "Taille : " + pokemon.getHeight() + "\n" +
                "Poids : " + pokemon.getWeight()+ "\n" +
                "===============================\n";
    }
}
