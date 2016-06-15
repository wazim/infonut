package infonut.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private String name;
    private String version;
    private String owner;
    private List<Address> addresses;
    private List<String> interactees;
    private String description;
    private String aggregate;

    public Application(String name, String version, String owner, List<Address> addresses, String description, List<String> interactees, String aggregate) {
        this.name = name;
        this.version = version;
        this.owner = owner;
        this.addresses = addresses;
        this.description = description;
        this.interactees = interactees;
        this.aggregate = aggregate;
    }

    public String name() {
        return name;
    }

    public String version() {
        return version;
    }

    public String description() {
        return description;
    }

    public List<Address> addresses() {
        return addresses;
    }

    public String owner() {
        return owner;
    }

    public String interactees() {
        return interactees.stream().collect(Collectors.joining(", "));
    }

    public String aggregate() {
        return aggregate;
    }
}
