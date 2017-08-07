package model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by EGlushchenko on 04/08/2017.
 */
public interface Subject extends Serializable {

    /**
     *  Get number of segments
     * @return number of segments of this subject
     */
    public int size();

    /**
     *  Get type of subject
     * @return
     */
    public SubjectType getType();

    /**
     * Get list of segments
     * @return list of segments
     */
    public List<Segment> getSegments();

}
