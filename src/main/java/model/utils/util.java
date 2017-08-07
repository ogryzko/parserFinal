package model.utils;

import model.SegmentType;
import model.io.rules.TagRule;

import java.text.ParseException;

/**
 * Created by eglushchenko on 07.08.2017.
 */
public class util {
    public static SegmentType getSegmentType(String line) throws ParseException {
        String[] arr = new String[1];
        if(new TagRule().applyTo(arr, null)){
            if(line.startsWith("ID")){
                // todo mda подумать о том что так жить нельзя
            }
        }
        return null;
    }
}
