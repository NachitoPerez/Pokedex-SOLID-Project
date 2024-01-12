package com.example.pokedex.services.DataBaseServices;

import com.example.pokedex.models.AppOptions;
import com.example.pokedex.models.PokemonModels.PokemonSQLITE;

import java.sql.*;

/**
 * SQLLiteService is the entity we'll be using to retrieve the information form the SQLITE file given by the user
 *
 * @author Ignacio Pérez
 *
 */

public class SQLLiteService {
    public PokemonSQLITE getPokemonInformationById(int pokemonId, String filePath) {
        /* Connect to the database */
        Connection conn = null;
        try {
            // demo local database
            String url = "jdbc:sqlite:pokemondatabase.sqlite";
            if(filePath != null) {
                url = filePath;
            }
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            PreparedStatement stmt  = conn.prepareStatement("SELECT name, description, weight, height FROM pokemons WHERE id = ?");
            stmt.setInt(1, pokemonId); // Sets the value "3" for parameter at position 1
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return new PokemonSQLITE(pokemonId, rs.getString("name"), rs.getString("description"), Float.parseFloat(rs.getString("weight")), Float.parseFloat(rs.getString("height")));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            return null;
    }
}
