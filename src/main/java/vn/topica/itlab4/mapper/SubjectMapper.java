package vn.topica.itlab4.mapper;

import vn.topica.itlab4.model.Subject;
import vn.topica.itlab4.model.SubjectDomain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapper implements RowMapper<Subject> {
    @Override
    public Subject mapRow(ResultSet resultSet) {
        Subject subject = new Subject();

        try {
            subject.setSubjectId(resultSet.getInt("id"));
            subject.setSubjectName(resultSet.getString("name"));
            subject.setSubjectDesc(resultSet.getString("description"));
            subject.setSubjectDomain(stringToSubjectDomain(resultSet.getString("domain")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return subject;
    }

    private SubjectDomain stringToSubjectDomain(String domainString) throws Exception {
        SubjectDomain subjectDomain;
        switch (domainString){
            case "MATHEMATICS":
                subjectDomain = SubjectDomain.MATHEMATICS;
                return subjectDomain;
            case "LITERATURE":
                subjectDomain = SubjectDomain.LITERATURE;
                return subjectDomain;
            case "PHYSICS":
                subjectDomain = SubjectDomain.PHYSICS;
                return subjectDomain;
            case "CHEMISTRY":
                subjectDomain = SubjectDomain.CHEMISTRY;
                return subjectDomain;
            case "BIOLOGY":
                subjectDomain = SubjectDomain.BIOLOGY;
                return subjectDomain;
            case "HISTORY":
                subjectDomain = SubjectDomain.HISTORY;
                return subjectDomain;
            case "GEOGRAPHY":
                subjectDomain = SubjectDomain.GEOGRAPHY;
                return subjectDomain;
            default:
                System.out.println("no subject domain");
                throw new Exception();
        }

    }
}
