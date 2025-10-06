package club.nullbyte3.facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiFacade {
    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException {
        String jsonResult = getJsonFromApi(urlString);
        return extractAttributeFromJson(jsonResult, attributeName);
    }

    private String getJsonFromApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    private String extractAttributeFromJson(String json, String attributeName) throws IllegalArgumentException, IOException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            Object value = jsonObject.get(attributeName);

            if (value == null) {
                throw new IllegalArgumentException("attribute '" + attributeName + "' was not found in the response.");
            }
            return String.valueOf(value);
        } catch (ParseException e) {
            throw new IOException("Not JSON?", e);
        }
    }
}
