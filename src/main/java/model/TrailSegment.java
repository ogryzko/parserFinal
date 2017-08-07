package model;

/**
 * Created by EGlushchenko on 04/08/2017.
 */
public class TrailSegment implements Segment {
    private final String SegmentTag; // M
    private final Integer Counter; // O

    public TrailSegment(String segmentTag, Integer counter) {
        SegmentTag = segmentTag;
        Counter = counter;
    }

    @Override
    public String toTUTDF() {
        return null; // TODO: 04/08/2017
    }

    @Override
    public void toTUTDF(StringBuffer stringBuffer) {
        // TODO: 04/08/2017
    }
}
