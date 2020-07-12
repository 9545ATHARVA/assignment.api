package configuration.commonUtils;

public enum ERROR {

    ERROR_NAME("error_name"),
    ERROR_MESSAGE("error_message"),
    ERROR_ID("error_id"),
    BAD_PARAMETER("bad_parameter"),
    NO_METHOD_FOUND("no method found with this name"),
    NO_METHOD("no_method"),
    IDS("ids");

    public String getError() {
        return error;
    }

    ERROR(String error) {
        this.error = error;
    }

    private String error;

}
