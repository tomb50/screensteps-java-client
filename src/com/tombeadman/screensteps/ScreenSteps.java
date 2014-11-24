package com.tombeadman.screensteps;

import com.tombeadman.screensteps.client.ScreenStepsClient;
import com.tombeadman.screensteps.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 24/11/14
 * Time: 18:16
 */
public class ScreenSteps {

    final ScreenStepsClient screenStepsClient;

    public ScreenSteps(final String username, final String password, final String domain) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("screensteps-spring.xml");
        screenStepsClient = applicationContext.getBean("screenstepsClient", ScreenStepsClient.class);
        screenStepsClient.login(username, password, domain);
    }

    public Spaces getSpaces() {
        return screenStepsClient.getSpaces();
    }

    public Space getSpace(final String spaceId) {
        return screenStepsClient.getSpace(spaceId);
    }

    public Manual getManual(final String spaceId, final String manualId) {
        return screenStepsClient.getManual(spaceId, manualId);
    }

    public Lesson getLesson(final String spaceId, final String manualId, final String lessonId) {
        return screenStepsClient.getLesson(spaceId, manualId, lessonId);
    }

    public Lessons searchSpaces(final String spaceId, final String searchText) {
        return screenStepsClient.searchSpaces(spaceId, searchText);
    }

    public Lessons searchManual(final String spaceId, final String manualId, final String searchText) {
        return screenStepsClient.searchManual(spaceId, manualId, searchText);
    }

    public Lessons searchTags(final String spaceId, final String tag) {
        return screenStepsClient.searchTags(spaceId, tag);
    }

    public Lessons searchTags(final String spaceId, final String manualId, final String tag) {
        return screenStepsClient.searchTags(spaceId, manualId, tag);
    }

}
