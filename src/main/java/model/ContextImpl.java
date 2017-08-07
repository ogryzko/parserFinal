package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eglushchenko on 07.08.2017.
 */
public class ContextImpl implements Context {

    private final Map<SegmentType, List<Segment>> segments;

    public ContextImpl(Map<SegmentType, List<Segment>> segments) {
        this.segments = segments;
    }

    public ContextImpl(){
        this.segments = new LinkedHashMap<>();
    }

    @Override
    public List<Segment> getAllByType(SegmentType type) {
        return new ArrayList<>(segments.get(type)); // immutable ???
    }

    @Override
    public Segment get(int index) {
        return getAll().get(index);
    }

    @Override
    public Segment getByTypeAndIndex(SegmentType type, int index) {
        return getAllByType(type).get(index);
    }

    @Override
    public void add(Segment segment) {
        SegmentType type = segment.getType();
        if(!segments.containsKey(type)){
            segments.put(type, new ArrayList<Segment>());
        }
        segments.get(type).add(segment);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<Segment> getAll() {
        ArrayList<Segment> list = new ArrayList<>();
        for(List<Segment> segmentsByType : segments.values()){
            list.addAll(segmentsByType);
        }
        return list;
    }
}
