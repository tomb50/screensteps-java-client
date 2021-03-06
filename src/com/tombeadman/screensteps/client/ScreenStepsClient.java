package com.tombeadman.screensteps.client;

import com.thoughtworks.xstream.core.util.Base64Encoder;
import com.tombeadman.screensteps.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


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

    ////////////////////////////////////////////////////////////////
    //
    // Calls : Spaces
    //
    ////////////////////////////////////////////////////////////////

    /*
     * Retrieves all Spaces -> /s or /spaces
     */
    public Spaces getSpaces() {
        final ResponseEntity<Spaces> responseEntity = restTemplate.exchange(baseURL + "/s", HttpMethod.GET,
                httpEntity, Spaces.class);
        return responseEntity.getBody();
    }

    /*
     * Retrieves a single Space -> /s/#{space_id} or /spaces/#{space_id}
     */
    public Space getSpace(final String spaceId) {
        final String url = "/s/".concat(spaceId);
        final ResponseEntity<Space> responseEntity = restTemplate.exchange(baseURL + url
                , HttpMethod.GET, httpEntity, Space.class);
        return responseEntity.getBody();
    }

    /*
     * Retrieves all Lessons in a Space that have content matching the search string
     * -> /s/#{space_id}/searches?text=#{search_text} or /spaces/#{space_id}/searches?text=#{search_text}
     */
    public Lessons searchSpaces(final String spaceId, final String searchText) {
        final String url = "/s/".concat(spaceId).concat("/searches?text=").concat(searchText);
        final ResponseEntity<Lessons> responseEntity = restTemplate.exchange(baseURL + url
                , HttpMethod.GET, httpEntity, Lessons.class);
        return responseEntity.getBody();

    }


    ////////////////////////////////////////////////////////////////
    //
    // Calls : Manuals
    //
    ////////////////////////////////////////////////////////////////

    /*
     * Retrieves a single Manual -> /s/#{space_id}/m/{#manual_id} or /spaces/#{space_id}/manuals/{#manual_id}
     */
    public Manual getManual(final String spaceId, final String manualId) {
        final String url = "/s/".concat(spaceId).concat("/m/").concat(manualId);
        final ResponseEntity<Manual> responseEntity = restTemplate.exchange(baseURL + url
                , HttpMethod.GET, httpEntity, Manual.class);
        return responseEntity.getBody();
    }

    /*
     * Retrieves a single Lesson =->  /s/#{space_id}/m/{#manual_id}/l/#{lesson_id}
     * or spaces/#{space_id}/manuals/{#manual_id}/lessons/#{lesson_id}
     */
    public Lesson getLesson(final String spaceId, final String manualId, final String lessonId) {
        final String url = "/s/".concat(spaceId).concat("/m/")
                .concat(manualId).concat("/l/").concat(lessonId);
        final ResponseEntity<Lesson> responseEntity = restTemplate.exchange(baseURL + url
                , HttpMethod.GET, httpEntity, Lesson.class);
        return responseEntity.getBody();
    }

    /*
 * Retrieves all Lessons in a Space that have content matching the search string
 * -> /s/#{space_id}/searches?text=#{search_text} or /spaces/#{space_id}/searches?text=#{search_text}
 */
    public Lessons searchManual(final String spaceId, final String manualId, final String searchText) {
        final String url = "/s/".concat(spaceId).concat("/m/")
                .concat(manualId).concat("/searches?text=").concat(searchText);
        final ResponseEntity<Lessons> responseEntity = restTemplate.exchange(baseURL + url
                , HttpMethod.GET, httpEntity, Lessons.class);
        return responseEntity.getBody();

    }

    /*
    * Retrieves all Lessons in a Manual for the specified tag
    * -> /s/#{space_id}/m/#{manual_id}/tags?tag=#{tag} or /spaces/#{space_id}/manuals/#{manual_id}/tags?tag=#{tag}
    */
    public Lessons searchTags(final String spaceId, final String manualId, final String tag) {
        final String url = "/s/".concat(spaceId).concat("/m/")
                .concat(manualId).concat("/tags?tag=").concat(tag);
        final ResponseEntity<Lessons> responseEntity = restTemplate.exchange(baseURL + url
                , HttpMethod.GET, httpEntity, Lessons.class);
        return responseEntity.getBody();

    }

    /*
    * Retrieves all Lessons in a Space for the specified tag
    * -> /s/#{space_id}/tags?tag=#{tag} or /spaces/#{space_id}/tags?tag=#{tag}
    */
    public Lessons searchTags(final String spaceId, final String tag) {
        final String url = "/s/".concat(spaceId).concat("/m/")
                .concat("/tags?tag=").concat(tag);
        final ResponseEntity<Lessons> responseEntity = restTemplate.exchange(baseURL + url
                , HttpMethod.GET, httpEntity, Lessons.class);
        return responseEntity.getBody();

    }


}
