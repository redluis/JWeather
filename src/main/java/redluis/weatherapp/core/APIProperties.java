package redluis.weatherapp.core;

public class APIProperties {
    private String API_KEY;
    private String API_URL_TEMPLATE;

    APIProperties() {}

    public APIProperties(String API_KEY, String API_URL_TEMPLATE) {
        this.API_KEY = API_KEY;
        this.API_URL_TEMPLATE = API_URL_TEMPLATE;
    }

    public String getApiKey() {
        return this.API_KEY;
    }

    public String getApiUrlTemplate() {
        return this.API_URL_TEMPLATE;
    }
}
