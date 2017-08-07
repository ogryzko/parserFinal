package model.io.rules;

import model.Context;
import model.SegmentType;
import model.io.exceptions.BadTagException;

/**
 * Created by eglushchenko on 04.08.2017.
 */
public class HeaderSegmentTagRule implements Rule {
    @Override
    public boolean applyTo(String[] fields, Context context) throws BadTagException {
        String segmentTag = fields[0];
        if(context.getAllByType(SegmentType.TUTDF) != null)
            throw new BadTagException("Only one header allowed", context.size() + 1);
        return true;
    }
}
