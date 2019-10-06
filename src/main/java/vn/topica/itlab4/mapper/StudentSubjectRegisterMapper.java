package vn.topica.itlab4.mapper;

import vn.topica.itlab4.model.StudentSubjectRegister;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentSubjectRegisterMapper implements RowMapper<StudentSubjectRegister>{
    @Override
    public StudentSubjectRegister mapRow(ResultSet resultSet) {
        StudentSubjectRegister studentSubjectRegister = new StudentSubjectRegister();
        try {
            studentSubjectRegister.setStudentId(resultSet.getInt("student_id"));
            studentSubjectRegister.setSubjectId(resultSet.getInt("subject_id"));
            studentSubjectRegister.setScore(resultSet.getDouble("score"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return studentSubjectRegister;
    }
}
