package model;

import java.util.List;

/**
 * Created by eglushchenko on 07.08.2017.
 */
public interface Context {
    /**
     *  Returns list of all segments in context by given type ordered as they were added to context
     * @param type
     * @return
     */
    List<Segment> getAllByType(SegmentType type);

    /**
     *  Returns segment by given index
     * @param index
     * @return
     */
    Segment get(int index);

    /**
     *  Returns segment by given index from list containing specified segments type
     * @param type
     * @param index
     * @return
     */
    Segment getByTypeAndIndex(SegmentType type, int index);

    /**
     *  Add segment
     * @param segment
     */
    void add(Segment segment);

    public int size();

    public List<Segment> getAll();
}
