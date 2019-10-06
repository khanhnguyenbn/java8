package vn.topica.itlab4.mapper;

import vn.topica.itlab4.model.School;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolMapper implements RowMapper<School> {
    @Override
    public School mapRow(ResultSet resultSet) {
        School school = new School();
        try {
            school.setSchoolId(resultSet.getInt("id"));
            school.setSchoolName(resultSet.getString("name"));
            school.setSchoolDesc(resultSet.getString("description"));
            return school;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
