package infonut.logic.deciders;

import infonut.domain.Application;
import infonut.repository.ApplicationRepository;

public class TeamCityStatusDecider implements Decider {

    private static final String STATUS_KEYWORD = "STATUS";
    private static final String BUILD_KEYWORD = "BUILD";
    private final ApplicationRepository applicationRepository;

    public TeamCityStatusDecider(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public boolean isRelevant(String searchTerm) {
        return searchTerm.contains(STATUS_KEYWORD) && searchTerm.contains(BUILD_KEYWORD);
    }

    @Override
    public String resolveSearchRequest(String searchTerm) {
        String applicationName = applicationRepository.extractNameFromSearchTerm(searchTerm);
        Application application = applicationRepository.getApplicationByName(applicationName);
        return String.format("%s is failing. One test has failed.", application.name());
    }

}
