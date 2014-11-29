import com.tombeadman.screensteps.ScreenSteps;
import com.tombeadman.screensteps.model.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;


/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 29/11/14
 * Time: 14:06
 */


/*
 * This runs a basic test on the user supplied credentials and main endpoints.
 * In the test.properties add your credentials and add the id for a lesson that you know is present and correct.
 * Add the respective manualId and Space id for which that lesson resides.
 */
public class ScreenStepsSmokeTest {

    static ScreenSteps screenSteps;
    static String user;
    static String password;
    static String domain;
    static String spaceId;
    static String manualId;
    static String lessonId;


    @BeforeClass
    public static void screenStepsShouldInitialise() {
        final Properties properties = new Properties();
        final String PROPERTY_FILE = "test.properties";
        InputStream inputStream = ScreenStepsSmokeTest.class.getResourceAsStream(PROPERTY_FILE);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            //Self explanatory
        }

        user = properties.getProperty("username");
        assertNotNull("user not specified", user);

        password = properties.getProperty("password");
        assertNotNull("password not specified", password);

        domain = properties.getProperty("domain");
        assertNotNull("domain not specified", domain);

        spaceId = properties.getProperty("spaceId");
        assertNotNull("spaceId not specified", spaceId);

        manualId = properties.getProperty("manualId");
        assertNotNull("manualId not specified", manualId);

        lessonId = properties.getProperty("lessonId");
        assertNotNull("lessonId not specified", lessonId);

        screenSteps = new ScreenSteps(user, password, domain);
        assertNotNull("ScreenSteps instance creation failed", screenSteps);
    }

    @Test
    public void spacesShouldBeFound() {
        final Spaces spaces = screenSteps.getSpaces();
        assertNotNull("Spaces should not be null", spaces);
    }

    @Test
    public void spaceShouldBeFound() {
        final Space space = screenSteps.getSpace(spaceId);
        assertNotNull("Space should not be null", space);
    }

    @Test
    public void manualShouldBeFound() {
        final Manual manual = screenSteps.getManual(spaceId, manualId);
        assertNotNull("Manual should not be null", manual);
    }

    @Test
    public void lessonShouldBeFound() {
        final Lesson lesson = screenSteps.getLesson(spaceId, manualId, lessonId);
        assertNotNull("lesson should not be null", lesson);
    }
}
