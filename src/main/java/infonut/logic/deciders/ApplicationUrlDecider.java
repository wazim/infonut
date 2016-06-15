package infonut.logic.deciders;

import infonut.domain.Address;
import infonut.domain.Application;
import infonut.repository.ApplicationRepository;
import infonut.repository.EnvironmentRepository;

import java.util.Optional;

public class ApplicationUrlDecider implements Decider {

    private static final String KEYWORD_ADDRESS = "ADDRESS";
    private static final String KEYWORD_URL = "URL";
    private final ApplicationRepository applicationRepository;
    private final EnvironmentRepository environmentRepository;

    public ApplicationUrlDecider(ApplicationRepository applicationRepository, EnvironmentRepository environmentRepository) {
        this.applicationRepository = applicationRepository;
        this.environmentRepository = environmentRepository;
    }

    @Override
    public boolean isRelevant(String searchTerm) {
        return searchTerm.contains(KEYWORD_ADDRESS) || searchTerm.contains(KEYWORD_URL);
    }

    @Override
    public String resolveSearchRequest(String searchTerm) {
        String name = applicationRepository.extractNameFromSearchTerm(searchTerm);
        Application application = applicationRepository.getApplicationByName(name);
        Optional<String> environment = environmentRepository.extractEnvironmentFromSearchTerm(searchTerm);
        Address theAddress;
        if (environment.isPresent()) {
            theAddress = application.addresses().stream()
                    .filter(address -> address.environment().equalsIgnoreCase(environment.get()))
                    .findFirst().orElse(application.addresses().get(0));
        } else {
            theAddress = application.addresses().get(0);
        }
        return String.format("The URL for %s in %s is %s", application.name(), theAddress.environment(), theAddress.url());
    }
}
