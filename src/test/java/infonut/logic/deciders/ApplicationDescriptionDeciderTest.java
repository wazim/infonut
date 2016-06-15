package infonut.logic.deciders;

import infonut.repository.ApplicationRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ApplicationDescriptionDeciderTest {

    private ApplicationDescriptionDecider applicationDescriptionDecider;
    private ApplicationRepository applicationRepository;

    @Before
    public void setUp() throws Exception {
        applicationRepository = new ApplicationRepository();
        applicationDescriptionDecider = new ApplicationDescriptionDecider(applicationRepository);
    }

    @Test
    public void isRelevantIfContainingKeywords() throws Exception {
        assertTrue(applicationDescriptionDecider.isRelevant("TELL ME ABOUT APP"));
    }

    @Test
    public void isNotRelevantIfNotContainingKeywords() throws Exception {
        assertFalse(applicationDescriptionDecider.isRelevant("WHAT IS APP"));
    }

    @Test
    public void resolveSearchRequest() throws Exception {
        String answer = applicationDescriptionDecider.resolveSearchRequest("TELL ME ABOUT APP");
        assertThat(answer, is(applicationRepository.getApplicationByName("App").description()));
    }
}