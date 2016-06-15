package infonut.repository;

import infonut.domain.Application;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ApplicationRepositoryTest {

    private ApplicationRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = new ApplicationRepository();
    }

    @Test
    public void extractNameFromSearchTerm() throws Exception {
        String extractedApplicationName = repository.extractNameFromSearchTerm("What version of App is running in Production?");
        assertThat(extractedApplicationName, is("App"));
    }

    @Test
    public void getApplicationByName() throws Exception {
        Application application = repository.getApplicationByName("ApP");

        assertThat(application.name(), is("App"));
    }
}