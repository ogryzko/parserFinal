package model.utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by genya on 08/08/2017.
 */
public class PatternGeneratorImpl implements PatternGenerator {
    private final Map<String,String> tokens;

    public PatternGeneratorImpl(Map<String, String> tokens) {
        this.tokens = tokens;
    }


    @Override
    public String generatePattern(String myFormattedString) {
        Pattern pattern = Pattern.compile(myFormattedString);
        Matcher matcher = pattern.matcher(preRegex); // // TODO: 08/08/2017  

        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            matcher.appendReplacement(sb, tokens.get(matcher.group(1)));
        }
        matcher.appendTail(sb);
        sb.append("\\s*");
        sb.insert(0, "\\s*");
    }
}
