package vn.topica.itlab4.mapper;

import vn.topica.itlab4.model.ClassOfSchool;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassMapper implements RowMapper<ClassOfSchool>{
    @Override
    public ClassOfSchool mapRow(ResultSet resultSet) {
        ClassOfSchool classOfSchool = new ClassOfSchool();
        try {
            classOfSchool.setClassId(resultSet.getInt("id"));
            classOfSchool.setSchoolId(resultSet.getInt("school_id"));
            classOfSchool.setClassCode(resultSet.getString("code"));
            classOfSchool.setClassDesc(resultSet.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return classOfSchool;
    }
}
