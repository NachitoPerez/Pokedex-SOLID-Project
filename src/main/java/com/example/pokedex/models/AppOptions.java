package com.example.pokedex.models;

import com.example.pokedex.models.PokemonModels.Pokemon;
import com.example.pokedex.utilities.OutputFormat;

/**
 * AppOptions is the entity we'll be using to represent the user preferences indicated as run arguments
 *
 * @author Ignacio Pérez
 *
 */

public class AppOptions {

    public enum DataSource {WEB_API, LOCAL_DATABASE}

    private DataSource dataSource;
    private String databasePath;
    private OutputFormat outputFormat;
    private int pokemonId;

    public AppOptions(){
        this.dataSource = DataSource.WEB_API;
        this.outputFormat = OutputFormat.TEXT;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setDatabasePath(String databasePath) {
        this.databasePath = databasePath;
    }

    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    public String getDatabasePath() {
        return databasePath;
    }
}
