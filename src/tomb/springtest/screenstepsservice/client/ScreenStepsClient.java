package tomb.springtest.screenstepsservice.client;

import com.thoughtworks.xstream.core.util.Base64Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tomb.springtest.screenstepsservice.model.*;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 20/11/14 Time: 20:21
 */
@Component("screenstepsClient")
public class ScreenStepsClient {
    @Autowired
    protected RestTemplate restTemplate;

    /*Direct config variables*/
    private String username;
    private String password;
    private String domain;
    private String authCode;

    /*Derived config*/
    private String baseURL;
    private String headerAuthKey;
    private String headerAuthValue;
    private HttpHeaders headers;
    private HttpEntity<?> httpEntity;


    public ScreenStepsClient() {
    }

    public void login(final String username, final String password, final String domain) {
        this.username = username;
        this.password = password;
        this.domain = domain;
        configure();
    }

    private void configure() {
        authCode = encode(username.concat(":").concat(password));
        baseURL = "https://".concat(domain).concat(".screenstepslive.com");
        headerAuthKey = "Authorization";
        headerAuthValue = "Basic ".concat(authCode);
        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.add(headerAuthKey, headerAuthValue);
        httpEntity = new HttpEntity<Object>(headers);
    }

    private String encode(String string) {
        final Base64Encoder base64Encoder = new Base64Encoder();
        return base64Encoder.encode(string.getBytes());
    }



    public Spaces getSpaces() {
        final ResponseEntity<Spaces> responseEntity = restTemplate.exchange(baseURL + "/s", HttpMethod.GET,
                httpEntity, Spaces.class);
        return responseEntity.getBody();
    }

    /*
     * Retrieves a single Space -> /s/#{space_id} or /spaces/#{space_id}
     */
    public Space getSpace(final Integer spaceId) {
        final String url = "/s/".concat(String.valueOf(spaceId));
        final ResponseEntity<Space> responseEntity = restTemplate.exchange(baseURL + url
                , HttpMethod.GET, httpEntity, Space.class);
        return responseEntity.getBody();
    }

    /*
     * Retrieves all Lessons in a Space that have content matching the search string
     * -> /s/#{space_id}/searches?text=#{search_text} or /spaces/#{space_id}/searches?text=#{search_text}
     */
  public Lessons searchSpaces(final Integer spaceId, final String searchText)
  {
      final String url = "/s/".concat(String.valueOf(spaceId)).concat("/searches?text=").concat(searchText);
      final ResponseEntity<Lessons> responseEntity = restTemplate.exchange(baseURL + url
              , HttpMethod.GET, httpEntity, Lessons.class);
      return responseEntity.getBody();

  }

    /*
     * Retrieves a single Manual -> /s/#{space_id}/m/{#manual_id} or /spaces/#{space_id}/manuals/{#manual_id}
     */
    public Manual getManual(final Integer spaceId, final Integer manualId) {
        final String url = "/s/".concat(String.valueOf(spaceId)).concat("/m/").concat(String.valueOf(manualId));
        final ResponseEntity<Manual> responseEntity = restTemplate.exchange(baseURL + url
                , HttpMethod.GET, httpEntity, Manual.class);
        return responseEntity.getBody();
    }

    /*
     * Retrieves a single Lesson =->  /s/#{space_id}/m/{#manual_id}/l/#{lesson_id}
     * or spaces/#{space_id}/manuals/{#manual_id}/lessons/#{lesson_id}
     */
    public Lesson getLesson(final Integer spaceId, final Integer manualId, final Integer lessonId) {
        final String url = "/s/".concat(String.valueOf(spaceId)).concat("/m/")
                .concat(String.valueOf(manualId)).concat("/l/").concat(String.valueOf(lessonId));
        final ResponseEntity<Lesson> responseEntity = restTemplate.exchange(baseURL + url
                , HttpMethod.GET, httpEntity, Lesson.class);
        return responseEntity.getBody();
    }


}
