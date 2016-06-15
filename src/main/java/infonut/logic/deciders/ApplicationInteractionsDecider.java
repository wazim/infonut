package infonut.logic.deciders;

import infonut.domain.Application;
import infonut.repository.ApplicationRepository;

public class ApplicationInteractionsDecider implements Decider {
    private static final String DESCRIPTION_KEYWORD_INTERACT = "INTERACT";
    private final ApplicationRepository applicationRepository;

    public ApplicationInteractionsDecider(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public boolean isRelevant(String searchTerm) {
        return searchTerm.contains(DESCRIPTION_KEYWORD_INTERACT);
    }

    @Override
    public String resolveSearchRequest(String searchTerm) {
        String appName = applicationRepository.extractNameFromSearchTerm(searchTerm);
        Application application = applicationRepository.getApplicationByName(appName);
        return String.format("%s interacts with %s", application.name(), application.interactees());
    }
}
