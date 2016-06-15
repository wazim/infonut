package infonut.repository;

import infonut.domain.Team;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TeamRepositoryTest {

    private TeamRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = new TeamRepository();
    }

    @Test
    public void extractNameFromSearchTerm() throws Exception {
        String name = repository.extractNameFromSearchTerm("Who is the team lead of the Blue team?");
        assertThat(name, is("Blue"));
    }

    @Test
    public void getTeamNameByName() throws Exception {
        Team team = repository.getTeamByName("Blue");
        assertThat(team.name(), is("Blue"));
    }
}