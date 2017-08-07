package model.io;

import model.HeaderSegment;

import java.util.Date;

/**
 * Created by EGlushchenko on 04/08/2017.
 */
public class FIleConvert {

    private static final String SEGMENT_HEADER_FORMAT = ""; //// TODO: 04/08/2017

    public static String toTUTDF(HeaderSegment headerSegment){
        String segmentTag = headerSegment.getSegmentTag(); // M
        String version = headerSegment.getVersion(); // M
        Date versionDate = headerSegment.getVersionDate(); // M
        String memberCode = headerSegment.getMemberCode(); // M
        String cycleIdentification = headerSegment.getCycleIdentification(); // O
        Date reportDate = headerSegment.getReportDate(); // M
        String authorizationCode = headerSegment.getAuthorizationCode(); // M
        String memberData = headerSegment.getMemberData(); // O
        String tutdfString = String.format(
                SEGMENT_HEADER_FORMAT, segmentTag,
                version, versionDate, memberCode,
                cycleIdentification, reportDate,
                authorizationCode, memberData);
        return null; // TODO: 04/08/2017
    }

    public static void toTUTDF(HeaderSegment headerSegment, StringBuffer stringBuffer){
        // // TODO: 04/08/2017
    }
}
