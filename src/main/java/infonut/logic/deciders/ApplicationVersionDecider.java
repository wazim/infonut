package infonut.logic.deciders;

import infonut.domain.Application;
import infonut.repository.ApplicationRepository;

public class ApplicationVersionDecider implements Decider {

    private static final String VERSION_KEYWORD = "VERSION";
    private final ApplicationRepository applicationRepository;

    public ApplicationVersionDecider(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public boolean isRelevant(String searchTerm) {
        return searchTerm.contains(VERSION_KEYWORD);
    }

    @Override
    public String resolveSearchRequest(String searchTerm) {
        String applicationName = applicationRepository.extractNameFromSearchTerm(searchTerm);
        Application application = applicationRepository.getApplicationByName(applicationName);
        return String.format("The current version for %s is %s", application.name(), application.version());
    }

}
