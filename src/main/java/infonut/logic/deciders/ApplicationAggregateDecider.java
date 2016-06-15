package infonut.logic.deciders;

import infonut.domain.Application;
import infonut.repository.ApplicationRepository;

public class ApplicationAggregateDecider implements Decider {

    private static final String KEYWORD_AGGREGATE = "AGGREGATE";
    private final ApplicationRepository applicationRepository;

    public ApplicationAggregateDecider(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public boolean isRelevant(String searchTerm) {
        return searchTerm.contains(KEYWORD_AGGREGATE);
    }

    @Override
    public String resolveSearchRequest(String searchTerm) {
        String appName = applicationRepository.extractNameFromSearchTerm(searchTerm);
        Application application = applicationRepository.getApplicationByName(appName);
        return String.format("%s is in the %s aggregate", application.name(), application.aggregate());
    }
}
