package vn.topica.itlab4.dao.impl;

import vn.topica.itlab4.dao.AbtractDAO;
import vn.topica.itlab4.dao.IClassDAO;
import vn.topica.itlab4.db.DBConnection;
import vn.topica.itlab4.mapper.ClassMapper;
import vn.topica.itlab4.model.ClassOfSchool;
import vn.topica.itlab4.model.School;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO extends AbtractDAO<ClassOfSchool> implements IClassDAO {

    @Override
    public List<ClassOfSchool> getAll() {
        return getAll("tbl_class", new ClassMapper());
    }
}
