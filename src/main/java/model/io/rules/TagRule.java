package model.io.rules;

import model.Context;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eglushchenko on 07.08.2017.
 */
public class TagRule implements Rule {
    Pattern pattern = Pattern.compile("\\s*([A-Z]{2}[\\d]{2}|[A-Z]{4,5})\\s*");
    @Override
    public boolean applyTo(String[] fields, Context context) throws ParseException {
        Matcher matcher = pattern.matcher(fields[0]);
        if(!matcher.matches()){
            throw new ParseException("Invalid tag", matcher.start()); // todo
        }
        return true;
    }
}
