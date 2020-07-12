package configuration.commonUtils;

public enum HEADERS {

    CONTENTTYPE("Content-type"),
    XROUTENAME("x-route-name"),
    XAPPLICATIONID("x-application-id");
    private String header;

    HEADERS(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }


}
