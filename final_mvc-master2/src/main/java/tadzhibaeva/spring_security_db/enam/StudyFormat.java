package tadzhibaeva.spring_security_db.enam;


public enum StudyFormat {

    CORRESPONDENCE_FORM("заочно"),
    FULL_TIME_FORM("очно");

    String format;

    StudyFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
