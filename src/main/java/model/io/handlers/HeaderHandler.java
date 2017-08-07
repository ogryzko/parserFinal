package model.io.handlers;

import model.Context;
import model.HeaderSegment;
import model.HeaderSegmentBuilder;
import model.io.rules.Rule;

import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eglushchenko on 07.08.2017.
 */
public class HeaderHandler implements Handler {
    private static final int HEADER_FIELDS_NUM = 8; // todo
    private final List<Rule> rules;
    private final Context context;
    private final Pattern pattern;

    public HeaderHandler(List<Rule> rules, Context context, Pattern pattern) {
        this.rules = rules;
        this.context = context;
        this.pattern = pattern;
    }

    @Override
    public HeaderSegment process(String line) throws ParseException {
        String[] fields = line.toUpperCase().split("\t", -1);
        if(fields.length != HEADER_FIELDS_NUM){
            return null;
        }
        if (rules != null) {
            for (Rule rule : rules) {
                try {
                    rule.applyTo(fields, context);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return null; // todo
                }
            }
        }
        Matcher matcher = pattern.matcher(line);
        if(!matcher.matches()){
            throw new ParseException("dsfs", 1); // todo
        }
        int n = matcher.groupCount();
        String[] stringValues = new String[n];
        for (int i = 1; i <= n; i++) {
            stringValues[i-1] = matcher.group(i);
        }
        return new HeaderSegmentBuilder(stringValues).build();
    }
}
