package vn.topica.itlab4.mapper;

import vn.topica.itlab4.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet) {
        Student student = new Student();
        try {
            student.setStudentId(resultSet.getInt("id"));
            student.setClassId(resultSet.getInt("class_id"));
            student.setStudentName(resultSet.getString("name"));
            student.setStudentMobile(resultSet.getString("mobile"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return student;
    }
}
