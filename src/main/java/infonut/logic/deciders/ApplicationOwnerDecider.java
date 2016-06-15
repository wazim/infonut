package infonut.logic.deciders;

import infonut.domain.Application;
import infonut.repository.ApplicationRepository;

public class ApplicationOwnerDecider implements Decider {

    private static final String OWN_KEYWORD = "OWN";
    private final ApplicationRepository applicationRepository;

    public ApplicationOwnerDecider(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public boolean isRelevant(String searchTerm) {
        return searchTerm.contains(OWN_KEYWORD);
    }

    @Override
    public String resolveSearchRequest(String searchTerm) {
        String applicationName = applicationRepository.extractNameFromSearchTerm(searchTerm);
        Application application = applicationRepository.getApplicationByName(applicationName);
        return String.format("The owner of %s is %s", application.name(), application.owner());
    }

}
