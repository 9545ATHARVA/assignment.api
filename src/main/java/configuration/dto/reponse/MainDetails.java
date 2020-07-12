package configuration.dto.reponse;

public class MainDetails {

    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;

    public Double getTemp() {
        return temp;
    }

    public Double getFeels_like() {
        return feels_like;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Integer getSea_level() {
        return sea_level;
    }

    public Integer getGrnd_level() {
        return grnd_level;
    }

    private Integer pressure;
    private Integer humidity;
    private Integer sea_level;
    private Integer grnd_level;

}
