package vn.topica.itlab4.model;

public class School {
    private String schoolName;
    private Integer schoolId;
    private String schoolDesc;

    public School(){

    }

    public School(Integer schoolId, String schoolName, String schoolDesc) {
        this.schoolName = schoolName;
        this.schoolId = schoolId;
        this.schoolDesc = schoolDesc;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolDesc() {
        return schoolDesc;
    }

    public void setSchoolDesc(String schoolDesc) {
        this.schoolDesc = schoolDesc;
    }

    @Override
    public String toString() {
        return String.format("shool: id = %d, name = %s", schoolId, schoolName);
    }
}
