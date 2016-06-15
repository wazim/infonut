package infonut.logic.deciders;

import infonut.repository.ApplicationRepository;

public class ApplicationDescriptionDecider implements Decider {
    private static final String DESCRIPTION_KEYWORD_TELL = "TELL";
    private static final String DESCRIPTION_KEYWORD_ABOUT = "ABOUT";
    private final ApplicationRepository applicationRepository;

    public ApplicationDescriptionDecider(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public boolean isRelevant(String searchTerm) {
        return searchTerm.contains(DESCRIPTION_KEYWORD_ABOUT) && searchTerm.contains(DESCRIPTION_KEYWORD_TELL);
    }

    @Override
    public String resolveSearchRequest(String searchTerm) {
        String appName = applicationRepository.extractNameFromSearchTerm(searchTerm);
        return applicationRepository.getApplicationByName(appName).description();
    }
}
