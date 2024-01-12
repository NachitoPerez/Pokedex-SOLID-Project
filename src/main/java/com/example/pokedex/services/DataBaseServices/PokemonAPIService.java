package com.example.pokedex.services.DataBaseServices;

import com.example.pokedex.models.PokemonModels.Pokemon;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * PokemonAPIService is the entity we'll be using to connect to the Pokemon API and get the Pokemon Information
 *
 * @author Ignacio Pérez
 *
 */

public class PokemonAPIService {
    public Pokemon getPokemonInformationById(int pokemonId) {
        String jsonResponse = "";
        try {

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            String uri = "https://pokeapi.co/api/v2/pokemon/" + pokemonId;
            HttpGet request = new HttpGet(uri);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                JSONObject obj =(JSONObject)resultObject;
                //float weight = Float.parseFloat(obj.get("weight").toString());
                //float height = Float.parseFloat(obj.get("height").toString());
                return new Pokemon(pokemonId, obj.get("name").toString(),
                        Float.parseFloat(obj.get("weight").toString()),
                        Float.parseFloat(obj.get("height").toString()));
            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
        }

        return null;
    }
}
