import model.HeaderSegment;
import model.io.handlers.HeaderHandler;
import org.junit.Test;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Created by eglushchenko on 07.08.2017.
 */
public class HandlersTest {

    @Test
    public void testProcees() throws ParseException {
        String patternString = "\\s*" +
                "([A-ZА-ЯЁ]{5})" +
                "\\s*\t\\s*" +
                "(.{4,6})" +
                "\\s*\t\\s*" +
                "(\\d{8})" +
                "\\s*\t\\s*" +
                "([A-ZA-ЯЁ\\d]{12})" +
                "\\s*\t\\s*" +
                "(.{0,8})" +
                "\\s*\t\\s*" +
                "(\\d{8})" +
                "\\s*\t\\s*" +
                "([A-ZА-ЯЁ\\d]{8})" +
                "\\s*\t\\s*" +
                "(.{0,80})" +
                "\\s*";
        HeaderHandler handler = new HeaderHandler(null, null, Pattern.compile(patternString));
        HeaderSegment segment = handler.process(TestConstants.TUTDF_BC.toUpperCase());
        System.out.println(segment);
    }
}
