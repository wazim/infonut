package infonut.logic.deciders;

import infonut.domain.Team;
import infonut.repository.TeamRepository;

public class TeamMembersDecider implements Decider {

    private static final String TEAM_MEMBER_KEYWORD = "MEMBER";
    private final TeamRepository teamRepository;

    public TeamMembersDecider(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public boolean isRelevant(String searchTerm) {
        return searchTerm.contains(TEAM_MEMBER_KEYWORD);
    }

    @Override
    public String resolveSearchRequest(String searchTerm) {
        String teamName = teamRepository.extractNameFromSearchTerm(searchTerm);
        Team team = teamRepository.getTeamByName(teamName);
        return String.format("The team members of %s are %s", team.name(), team.members());
    }
}
