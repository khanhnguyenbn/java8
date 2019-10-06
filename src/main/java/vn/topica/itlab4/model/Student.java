package vn.topica.itlab4.model;

public class Student {

    private Integer studentId;
    private String studentName;
    private String studentMobile;
    private Integer classId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return String.format("Student: id = %d, name = %s, mobile = %s , classId = %d"
                , studentId, studentName, studentMobile, classId);
    }
}
