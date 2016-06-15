package infonut.logic.deciders;

public interface Decider {

    boolean isRelevant(String searchTerm);
    String resolveSearchRequest(String searchTerm);
}
