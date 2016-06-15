package infonut.repository;

import infonut.domain.Team;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TeamRepository {

    private final Map<String, Team> teams = new HashMap<>();

    public TeamRepository() {
        Team blueTeam = new Team(
                "Blue",
                "Davy Jones",
                Arrays.asList("Davy", "Arnie", "Jimmy", "Billy")
        );

        Team redTeam = new Team(
                "Red",
                "Bobby A",
                Arrays.asList("Bobby", "Danny", "Jack", "Kate", "Hurley")
        );

        teams.put("Blue", blueTeam);
        teams.put("Red", redTeam);
    }

    public String extractNameFromSearchTerm(String searchTerm) {
        return teams.entrySet().stream().filter(team -> searchTerm.toUpperCase().contains(team.getKey().toUpperCase())).findFirst().get().getValue().name();
    }

    public Team getTeamByName(String teamName) {
        return teams.entrySet().stream().filter(team -> team.getKey().equalsIgnoreCase(teamName)).findFirst().get().getValue();
    }

}
