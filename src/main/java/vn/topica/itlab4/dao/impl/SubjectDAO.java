package vn.topica.itlab4.dao.impl;

import vn.topica.itlab4.dao.AbtractDAO;
import vn.topica.itlab4.dao.IStudentDAO;
import vn.topica.itlab4.dao.ISubjectDAO;
import vn.topica.itlab4.mapper.SubjectMapper;
import vn.topica.itlab4.model.Student;
import vn.topica.itlab4.model.Subject;

import java.util.List;

public class SubjectDAO extends AbtractDAO<Subject> implements ISubjectDAO {
    @Override
    public List<Subject> getAll() {
        return getAll("tbl_subject", new SubjectMapper());
    }
}
