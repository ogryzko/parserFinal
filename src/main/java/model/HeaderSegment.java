package model;

import model.io.FIleConvert;

import java.util.Date;

/**
 * Created by genya on 04/08/2017.
 */
public class HeaderSegment implements Segment {
    private final String segmentTag; // M
    private final String version; // M
    private final Date versionDate; // M
    private final String memberCode; // M
    private final String cycleIdentification; // O
    private final Date reportDate; // M
    private final String authorizationCode; // M
    private final String memberData; // O


    public HeaderSegment(String segmentTag, String version, Date versionDate, String memberCode,
                         String cycleIdentification, Date reportDate, String authorizationCode, String memberData) {
        this.segmentTag = segmentTag;
        this.version = version;
        this.versionDate = versionDate;
        this.memberCode = memberCode;
        this.cycleIdentification = cycleIdentification;
        this.reportDate = reportDate;
        this.authorizationCode = authorizationCode;
        this.memberData = memberData;
    }



    @Override
    public String toTUTDF() {
        return FIleConvert.toTUTDF(this);
    }

    @Override
    public void toTUTDF(StringBuffer stringBuffer) {
         FIleConvert.toTUTDF(this, stringBuffer);
    }

    public String getSegmentTag() {
        return segmentTag;
    }

    public String getVersion() {
        return version;
    }

    public Date getVersionDate() {
        return versionDate;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public String getCycleIdentification() {
        return cycleIdentification;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public String getMemberData() {
        return memberData;
    }

    @Override
    public SegmentType getType() {
        return SegmentType.TUTDF;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HeaderSegment{");
        sb.append("segmentTag='").append(segmentTag).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append(", versionDate=").append(versionDate);
        sb.append(", memberCode='").append(memberCode).append('\'');
        sb.append(", cycleIdentification='").append(cycleIdentification).append('\'');
        sb.append(", reportDate=").append(reportDate);
        sb.append(", authorizationCode='").append(authorizationCode).append('\'');
        sb.append(", memberData='").append(memberData).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
