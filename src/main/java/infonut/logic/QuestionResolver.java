package infonut.logic;

import infonut.Response;
import infonut.logic.deciders.*;
import infonut.repository.ApplicationRepository;
import infonut.repository.EnvironmentRepository;
import infonut.repository.TeamRepository;

import java.util.List;

import static java.util.Arrays.asList;

public class QuestionResolver {
    private List<Decider> deciders;

    public QuestionResolver(ApplicationRepository applicationRepository, TeamRepository teamRepository, EnvironmentRepository environmentRepository) {
        deciders = asList(
                new ApplicationVersionDecider(applicationRepository),
                new ApplicationDescriptionDecider(applicationRepository),
                new ApplicationUrlDecider(applicationRepository, environmentRepository),
                new ApplicationOwnerDecider(applicationRepository),
                new TeamLeaderDecider(teamRepository),
                new TeamMembersDecider(teamRepository),
                new TeamCityRunnerDecider(applicationRepository),
                new TeamCityStatusDecider(applicationRepository),
                new ApplicationInteractionsDecider(applicationRepository),
                new ApplicationAggregateDecider(applicationRepository)
        );
    }

    public Response resolve(String question) {
        for (Decider decider : deciders) {
            if (decider.isRelevant(question.toUpperCase())) {
                return new Response(decider.resolveSearchRequest(question));
            }
        }
        return new Response("I'm sorry, I didn't quite catch that.");
    }
}
