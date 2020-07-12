package configuration.dto.reponse;

public class WeatherDetails {
    private String id;
    private String main;
    private String description;

    public String getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    private String icon;
}
