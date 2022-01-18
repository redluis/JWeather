package redluis.weatherapp.core;

import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class RXWeather {
    private APIProperties apiProperties;

    public RXWeather() {
        try {
            this.apiProperties = APIPropertiesReader.readProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getWeatherJson(String city) throws IOException {
        String urlString = apiProperties.getApiUrlTemplate()
                .replace("{{CITY_NAME}}", city)
                .replace("{{API_KEY}}", apiProperties.getApiKey());
            URL url = new URL(urlString);
            InputStream inputStream = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    inputStream, Charset.forName("UTF-8")
            ));

            String jsonString = readAll(bufferedReader);

            return jsonString;
    }

    public WeatherModel receiveWeather(String city) {
        String jsonString = null;
        try {
            jsonString = getWeatherJson(city);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject(jsonString);

        return new WeatherModel(jsonObject.getJSONObject("main"));
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
