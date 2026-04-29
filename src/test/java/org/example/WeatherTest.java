package org.example;



import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {

    @Test
    public void testJsonParsing() {
        // 1. Arrange: Create a fake JSON string (like what the API returns)
        String fakeJsonResponse = "{\"main\": {\"temp\": 32.5}, \"name\": \"Bengaluru\"}";

        // 2. Act: Parse the data using the same logic as your Main class
        JsonObject jsonObject = JsonParser.parseString(fakeJsonResponse).getAsJsonObject();
        double temp = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
        String city = jsonObject.get("name").getAsString();

        // 3. Assert: Check if the values match what we expect
        assertEquals(32.5, temp, "Temperature should be 32.5");
        assertEquals("Bengaluru", city, "City name should match");
    }
}