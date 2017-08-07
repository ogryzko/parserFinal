package model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by EGlushchenko on 04/08/2017.
 */
public interface TUTDFData extends Serializable {

    /**
     *  Get header segment (TUTDF ...) of this file
     * @return
     */
    public HeaderSegment getHeader();

    /**
     *  Get list of subjects
     * @return
     */
    public List<Subject> getSubjects();

    /**
     * Get number of subjects in this file
     */
    public int size();

    /**
     * Get trail segment (TRLR ...) of this file
     * @return
     */
    public TrailSegment getTrail();
}
