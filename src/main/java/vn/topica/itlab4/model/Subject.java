package vn.topica.itlab4.model;

public class Subject {
    private String subjectName;
    private Integer subjectId;
    private String subjectDesc;
    private SubjectDomain subjectDomain;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectDesc() {
        return subjectDesc;
    }

    public void setSubjectDesc(String subjectDesc) {
        this.subjectDesc = subjectDesc;
    }

    public SubjectDomain getSubjectDomain() {
        return subjectDomain;
    }

    public void setSubjectDomain(SubjectDomain subjectDomain) {
        this.subjectDomain = subjectDomain;
    }

    @Override
    public String toString() {
        return String.format("Subject: id = %d, name = %s", subjectId, subjectName);
    }
}
