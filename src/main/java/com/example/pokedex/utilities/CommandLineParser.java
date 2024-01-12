package com.example.pokedex.utilities;

import com.example.pokedex.Exceptions.PokemonCommandLineParsingException;
import com.example.pokedex.models.AppOptions;
import com.example.pokedex.utilities.OutputFormat;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * CommandLineParser is the entity we'll be using to parse the user preferences indicated as run arguments
 *
 * @author Ignacio Pérez
 *
 */
public class CommandLineParser {
    public static AppOptions parseCommandLineArguments(String[] args) throws PokemonCommandLineParsingException, ParseException {
        org.apache.commons.cli.CommandLineParser parser = new DefaultParser();
        AppOptions appOptions = new AppOptions();
        Options options = new Options();
        options.addOption("d", "database", true, "Path to a SQLite database containing pokemons");
        options.addOption("f", "format", true, "Specify the output format, between 'text', 'html' and 'csv'. By default 'text'.");

        // parse the command line arguments
        CommandLine line = parser.parse(options, args);
        if (line.hasOption("d")) {
            appOptions.setDataSource(AppOptions.DataSource.LOCAL_DATABASE);
            appOptions.setDatabasePath(line.getOptionValue("d"));
        }

        if (line.hasOption("f")) {
            String formatArgValue = line.getOptionValue("f");
            OutputFormat outputFormat = OutputFormat.TEXT;
            switch (formatArgValue) {
                case "text":
                    break;
                case "html":
                    outputFormat = OutputFormat.HTML;
                    break;
                case "csv":
                    outputFormat = OutputFormat.CSV;
                    break;
                default:
                    throw new PokemonCommandLineParsingException("Invalid value for the option -f/--format", options);
            }

            appOptions.setOutputFormat(outputFormat);
        }

        // Get pokemon ID from remaining arguments
        String[] remainingArgs = line.getArgs();
        if (remainingArgs.length < 1) {
            throw new PokemonCommandLineParsingException("You must provide a pokemon ID", options);
        }
        try {
            int pokemonId = Integer.parseInt(remainingArgs[0]);
            appOptions.setPokemonId(pokemonId);
        } catch (NumberFormatException e) {
            throw new PokemonCommandLineParsingException("'" + remainingArgs[0] + "' is not a valid pokemon ID", options);
        }

        return appOptions;

    }
}
