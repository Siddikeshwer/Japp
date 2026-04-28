package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

//public class Main {
//    public static void main(String[] args) {
//        // 1. Create some data
//        Map<String, Object> weatherData = new HashMap<>();
//        weatherData.put("city", "Bengaluru");
//        weatherData.put("temperature", "32°C");
//        weatherData.put("condition", "Sunny");
//        weatherData.put("humidity", 45);
//
//        // 2. Use the Gson library (downloaded by Maven) to format it
//        // The "Gson" class is NOT part of standard Java; Maven provided it!
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String jsonOutput = gson.toJson(weatherData);
//
//        // 3. Print the output
//        System.out.println("--- Startup Weather Report ---");
//        System.out.println(jsonOutput);
//    }
//
import static spark.Spark.*;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        // This line tells Spark to host a website on port 4567
        port(4567);

        // This allows your UI (Frontend) to talk to your Java (Backend)
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        // Creating the Route
        get("/weather", (req, res) -> {
            res.type("application/json");

            // Your logic to get weather (simulated here)
            WeatherReport report = new WeatherReport("Bengaluru", "32°C", "Clear");

            return new Gson().toJson(report);
        });
    }
}

// Simple class to hold data
class WeatherReport {
    String city, temp, info;
    public WeatherReport(String c, String t, String i) {
        this.city = c; this.temp = t; this.info = i;
    }
}