package infonut.domain;

public class Address {
    private String environment;
    private String url;

    public Address(String environment, String url) {
        this.environment = environment;
        this.url = url;
    }

    public String environment() {
        return environment;
    }

    public String url() {
        return url;
    }
}
