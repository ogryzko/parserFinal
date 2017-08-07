package model.io.handlers;

import model.Segment;

import java.text.ParseException;

/**
 * Created by eglushchenko on 07.08.2017.
 */
public interface Handler {

    Segment process(String line) throws ParseException;
}
