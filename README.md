After cloning this repository, if you have a Java environment on your machine, you can directly run the commands.


# Build the project

```
./gradlew build
```



# Run the application

```
./gradlew run
```

To run the application with command line arguments :

```
./gradlew run --args="<PokemonId> [-d|--database <databaseFile>] [-f|--format <format>]"
```

```-d|--database``` allows the user to obtain pokemon data from another data source indicating the FilePath.  

```-f|--format``` allows the user to choice the output format with the values ***text***, ***html***, or ***csv***. By default, if the option is not specified, the output format is ***text***.  

