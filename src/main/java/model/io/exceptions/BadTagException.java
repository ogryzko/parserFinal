package model.io.exceptions;

import java.text.ParseException;

/**
 * Created by eglushchenko on 07.08.2017.
 */
public class BadTagException extends ParseException {
    /**
     * Constructs a ParseException with the specified detail message and
     * offset.
     * A detail message is a String that describes this particular exception.
     *
     * @param s           the detail message
     * @param errorOffset the position where the error is found while parsing.
     */
    public BadTagException(String s, int errorOffset) {
        super(s, errorOffset);
    }
}
