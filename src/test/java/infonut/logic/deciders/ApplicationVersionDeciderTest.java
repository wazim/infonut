package infonut.logic.deciders;

import infonut.repository.ApplicationRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ApplicationVersionDeciderTest {

    private ApplicationVersionDecider applicationVersionDecider;
    private ApplicationRepository applicationRepository;

    @Before
    public void setUp() throws Exception {
        applicationRepository = new ApplicationRepository();
        applicationVersionDecider = new ApplicationVersionDecider(applicationRepository);
    }

    @Test
    public void isRelevantIfContainingKeywords() throws Exception {
        assertTrue(applicationVersionDecider.isRelevant("WHAT VERSION IS APP"));
    }

    @Test
    public void isNotRelevantIfNotContainingKeywords() throws Exception {
        assertFalse(applicationVersionDecider.isRelevant("HI"));
    }

    @Test
    public void resolveSearchRequest() throws Exception {
        String answer = applicationVersionDecider.resolveSearchRequest("WHAT VERSION IS APP");
        assertThat(answer, is(String.format("The current version for App is %s", applicationRepository.getApplicationByName("App").version())));
    }
}