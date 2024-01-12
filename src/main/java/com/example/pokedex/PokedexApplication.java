package com.example.pokedex;


import com.example.pokedex.controllers.PokemonController;
import com.example.pokedex.models.AppOptions;
import com.example.pokedex.Exceptions.PokemonCommandLineParsingException;
import com.example.pokedex.models.PokemonViewBuilder;
import com.example.pokedex.utilities.CommandLineParser;
import com.example.pokedex.utilities.ConsoleOutputUtility;
import com.example.pokedex.utilities.MultipleFormatGenerator;
import org.apache.commons.cli.*;

import static com.example.pokedex.models.AppOptions.DataSource.LOCAL_DATABASE;

/**
 * PokedexApplication is the entity we'll be using to run our application
 * [RUN] Arguments: "<PokemonId> [-d|--database <databaseFile>] [-f|--format <format>]"
 *
 * @author Ignacio Pérez
 *
 */

public class PokedexApplication {

    public static void main(String[] args) throws ParseException, PokemonCommandLineParsingException {
        // Get run arguments
        AppOptions appOptions = new AppOptions();
        try {
            appOptions = CommandLineParser.parseCommandLineArguments(args);
        } catch (PokemonCommandLineParsingException e) {
            System.err.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("./Pokedex <PokemonId> [-d|--database <databaseFile>] [-f|--format <format>]", e.getOptions());
            System.exit(0);
        }

        int pokemonId = appOptions.getPokemonId();
        PokemonController pokemonController = new PokemonController();
        MultipleFormatGenerator pokemonView = null;

        // Get Pokemon & Create View
        if (appOptions.getDataSource() == LOCAL_DATABASE){
            // Create View for show local SQLITE file pokemon info
            pokemonView = PokemonViewBuilder.createPokemonView(pokemonController.getPokemonById(pokemonId, appOptions.getDatabasePath()));
        } else {
            // Create View for show API pokemon info
            pokemonView = PokemonViewBuilder.createPokemonView(pokemonController.getPokemonById(pokemonId));
        }

        // Create Output
        ConsoleOutputUtility consoleOutputUtility = new ConsoleOutputUtility(appOptions.getOutputFormat(), pokemonView);
        consoleOutputUtility.makeOutput();
    }
}
