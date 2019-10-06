package vn.topica.itlab4.dao.impl;

import vn.topica.itlab4.dao.AbtractDAO;
import vn.topica.itlab4.dao.IStudentDAO;
import vn.topica.itlab4.mapper.StudentMapper;
import vn.topica.itlab4.model.Student;

import java.util.List;

public class StudentDAO extends AbtractDAO<Student> implements IStudentDAO {
    @Override
    public List<Student> getAll() {
        return getAll("tbl_student", new StudentMapper());
    }
}
