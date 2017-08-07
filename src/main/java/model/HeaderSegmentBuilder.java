package model;

import model.utils.Constants;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by eglushchenko on 07.08.2017.
 */
public class HeaderSegmentBuilder {
    private String segmentTag; // M
    private String version; // M
    private Date versionDate; // M
    private String memberCode; // M
    private String cycleIdentification; // O
    private Date reportDate; // M
    private String authorizationCode; // M
    private String memberData; // O

    public HeaderSegmentBuilder(String[] stringValues) throws ParseException {
        setSegmentTag(stringValues[0]);
        setVersion(stringValues[1]);
        setVersionDate(stringValues[2]);
        setMemberCode(stringValues[3]);
        setCycleIdentification(stringValues[4]);
        setReportDate(stringValues[5]);
        setAuthorizationCode(stringValues[6]);
        setMemberData(stringValues[7]);
    }

    public HeaderSegmentBuilder setSegmentTag(String segmentTag) {
        this.segmentTag = segmentTag;
        return this;
    }

    public HeaderSegmentBuilder setVersion(String version) {
        this.version = version;
        return this;
    }

    public HeaderSegmentBuilder setVersionDate(Date versionDate) {
        this.versionDate = versionDate;
        return this;
    }

    public HeaderSegmentBuilder setVersionDate(String versionDateString) throws ParseException {
        Date versionDate = Constants.sdf.parse(versionDateString);
        this.versionDate = versionDate;
        return this;
    }

    public HeaderSegmentBuilder setMemberCode(String memberCode) {
        this.memberCode = memberCode;
        return this;
    }

    public HeaderSegmentBuilder setCycleIdentification(String cycleIdentification) {
        this.cycleIdentification = cycleIdentification;
        return this;
    }

    public HeaderSegmentBuilder setReportDate(Date reportDate) {
        this.reportDate = reportDate;
        return this;
    }

    public HeaderSegmentBuilder setReportDate(String reportDateString) throws ParseException {
        this.reportDate = Constants.sdf.parse(reportDateString);
        return this;
    }

    public HeaderSegmentBuilder setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
        return this;
    }

    public HeaderSegmentBuilder setMemberData(String memberData) {
        this.memberData = memberData;
        return this;
    }

    public HeaderSegment build(){
        return new HeaderSegment(segmentTag, version, versionDate, memberCode, cycleIdentification, reportDate, authorizationCode, memberData);
    }
}
