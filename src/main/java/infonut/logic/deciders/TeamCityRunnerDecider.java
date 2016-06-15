package infonut.logic.deciders;

import infonut.domain.Application;
import infonut.repository.ApplicationRepository;

public class TeamCityRunnerDecider implements Decider {

    private static final String RUN_KEYWORD = "RUN";
    private static final String BUILD_KEYWORD = "BUILD";
    private final ApplicationRepository applicationRepository;

    public TeamCityRunnerDecider(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public boolean isRelevant(String searchTerm) {
        return searchTerm.contains(RUN_KEYWORD) && searchTerm.contains(BUILD_KEYWORD);
    }

    @Override
    public String resolveSearchRequest(String searchTerm) {
        String applicationName = applicationRepository.extractNameFromSearchTerm(searchTerm);
        Application application = applicationRepository.getApplicationByName(applicationName);
        return String.format("Okay, I've triggered a build to run for %s", application.name());
    }

}
