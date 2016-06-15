package infonut.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnvironmentRepository {

    private List<String> environments = new ArrayList<>();

    public EnvironmentRepository() {
        environments.add("Production");
        environments.add("Staging");
    }

    public Optional<String> extractEnvironmentFromSearchTerm(String searchTerm) {
        System.out.println(searchTerm);
        return environments.stream().filter(env -> searchTerm.toUpperCase().contains(env.toUpperCase())).findFirst();
    }


}
