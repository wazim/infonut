package infonut.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Team {
    private String name;
    private String teamLead;
    private List<String> members;

    public Team(String name, String teamLead, List<String> members) {
        this.name = name;
        this.teamLead = teamLead;
        this.members = members;
    }

    public String name() {
        return name;
    }

    public String teamLeader() {
        return teamLead;
    }

    public String members() {
        return members.stream().collect(Collectors.joining(", "));
    }
}
