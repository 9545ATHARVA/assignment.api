package configuration.commonUtils;

public enum PARMETERS {
    API_ID("appid"),
    UNITS("units"),
    TempInFahrenheit("imperial"),
    TempInCelsious("metric"),
    CityNameAttribute("q"),
    MIN("min");


    private String parmeter;

    PARMETERS(String parmeter) {
        this.parmeter = parmeter;
    }

    public String getParmeter() {
        return parmeter;
    }

    public void setParmeter(String parmeter) {
        this.parmeter = parmeter;
    }


}
