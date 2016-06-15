package infonut;

import infonut.logic.QuestionResolver;
import infonut.repository.ApplicationRepository;
import infonut.repository.EnvironmentRepository;
import infonut.repository.TeamRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationConfig {

    @Bean
    public ApplicationRepository applicationRepository() {
        return new ApplicationRepository();
    }

    @Bean
    public TeamRepository teamRepository() {
        return new TeamRepository();
    }

    @Bean
    public EnvironmentRepository environmentRepository(){
        return new EnvironmentRepository();
    }

    @Bean
    public QuestionResolver questionResolver(){
        return new QuestionResolver(
                applicationRepository(),
                teamRepository(),
                environmentRepository()
        );
    }
}
