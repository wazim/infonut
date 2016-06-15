package infonut.logic.deciders;

import infonut.domain.Team;
import infonut.repository.TeamRepository;

public class TeamLeaderDecider implements Decider {

    private static final String TEAM_LEADER_KEYWORD = "LEAD";
    private final TeamRepository teamRepository;

    public TeamLeaderDecider(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public boolean isRelevant(String searchTerm) {
        return searchTerm.contains(TEAM_LEADER_KEYWORD);
    }

    @Override
    public String resolveSearchRequest(String searchTerm) {
        String teamName = teamRepository.extractNameFromSearchTerm(searchTerm);
        Team team = teamRepository.getTeamByName(teamName);
        return String.format("The team leader of %s is %s", team.name(), team.teamLeader());
    }
}
