package model.io.rules;

import model.Context;

import java.text.ParseException;

/**
 * Created by eglushchenko on 07.08.2017.
 */
public interface Rule{
    public boolean applyTo(String[] fields, Context context) throws ParseException;
}
