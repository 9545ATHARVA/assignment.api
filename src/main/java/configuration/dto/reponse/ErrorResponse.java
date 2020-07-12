package configuration.dto.reponse;

import java.util.List;

public class ErrorResponse {


    private String error_message;
    private int error_id;
    private String error_name;

    public String getError_message() {
        return error_message;
    }

    public int getError_id() {
        return error_id;
    }

    public String getError_name() {
        return error_name;
    }

    public ErrorResponse() {
    }

}
