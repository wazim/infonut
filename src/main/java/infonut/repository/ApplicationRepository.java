package infonut.repository;

import infonut.domain.Address;
import infonut.domain.Application;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class ApplicationRepository {

    private List<Application> applications = new ArrayList<>();

    public ApplicationRepository() {
        applications.add(
                new Application(
                        "App",
                        "1923",
                        "Blue",
                        asList(
                                new Address("Production", "blue-app.company.com"),
                                new Address("Staging", "blue-app.staging.company.com")
                        ),
                        "The App does stuff that needs to be done.",
                        asList(
                                "Another App",
                                "Yet Another App"
                        ),
                        "Aggregate 1"
                )
        );
    }

    public String extractNameFromSearchTerm(String searchTerm) {
        System.out.println(searchTerm);
        return applications.stream().filter(app -> searchTerm.toUpperCase().contains(app.name().toUpperCase())).findFirst().get().name();
    }

    public Application getApplicationByName(String name) {
        return applications.stream().filter(app -> app.name().equalsIgnoreCase(name)).findFirst().get();
    }

}
