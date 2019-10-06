package vn.topica.itlab4.dao.impl;

import vn.topica.itlab4.dao.AbtractDAO;
import vn.topica.itlab4.dao.ISchoolDAO;
import vn.topica.itlab4.db.DBConnection;
import vn.topica.itlab4.mapper.SchoolMapper;
import vn.topica.itlab4.model.School;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO extends AbtractDAO<School> implements ISchoolDAO {


    @Override
    public List<School> getAll() {
        return getAll("tbl_school", new SchoolMapper());
    }
}
