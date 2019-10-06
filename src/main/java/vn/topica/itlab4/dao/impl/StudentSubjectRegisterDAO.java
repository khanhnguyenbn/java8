package vn.topica.itlab4.dao.impl;

import vn.topica.itlab4.dao.AbtractDAO;
import vn.topica.itlab4.dao.IStudentSubjectRegisterDAO;
import vn.topica.itlab4.mapper.StudentSubjectRegisterMapper;
import vn.topica.itlab4.model.StudentSubjectRegister;

import java.util.List;

public class StudentSubjectRegisterDAO extends AbtractDAO<StudentSubjectRegister> implements IStudentSubjectRegisterDAO {
    @Override
    public List<StudentSubjectRegister> getAll() {
        return getAll("tbl_student_subject_register", new StudentSubjectRegisterMapper());
    }
}
