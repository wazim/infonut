package infonut;

import infonut.logic.QuestionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class QueryController {

    @Autowired
    private QuestionResolver questionResolver;

    @RequestMapping(value = "q", method = POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response askInfonut(@RequestBody Map<String, String> payload) {
        String question = payload.get("question");
        return questionResolver.resolve(question);
    }

}
