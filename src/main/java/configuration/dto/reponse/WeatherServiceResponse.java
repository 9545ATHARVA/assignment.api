package configuration.dto.reponse;

import java.util.List;

public class WeatherServiceResponse {


    Coordination  coord;
    private List<WeatherDetails>  weather;
    private String  base;
    MainDetails  main;
    WindDetails  wind;
    Clouds clouds;
    private long  dt;
    Sys  sys;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer code;

    public Coordination getCoord() {
        return coord;
    }

    public List<WeatherDetails> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public MainDetails getMain() {
        return main;
    }

    public WindDetails getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public long getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
}
