package vn.topica.itlab4.main;

import vn.topica.itlab4.dao.impl.*;
import vn.topica.itlab4.model.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SchoolDAO schoolDAO = new SchoolDAO();
        ClassDAO classDAO = new ClassDAO();
        StudentDAO studentDAO = new StudentDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        StudentSubjectRegisterDAO studentSubjectRegisterDAO = new StudentSubjectRegisterDAO();

        List<School> schoolList = schoolDAO.getAll();
        List<ClassOfSchool> classOfSchoolList = classDAO.getAll();
        List<Student> studentList = studentDAO.getAll();
        List<Subject> subjectList = subjectDAO.getAll();
        List<StudentSubjectRegister> studentSubjectRegisterList = studentSubjectRegisterDAO.getAll();

        List<SubjectDomain> subjectDomainList = Arrays.asList(SubjectDomain.values());


        //Excercise 2.1: Get total of students of each school
        System.out.println("==================== EXCERCISE 2.1 ================================");
        schoolList.forEach(school -> {
            System.out.println(school.toString());
            int total = classOfSchoolList.stream()
                    .filter(cl -> cl.getSchoolId() == school.getSchoolId())
                    .mapToInt(cl -> (int) studentList.stream()
                            .filter(student -> student.getClassId() == cl.getClassId()).count()).sum();
            System.out.println(total);
        });

        //Excercise 2.2: average score of each subject of each school
        System.out.println("============================= EXCERCISE 2.2 =============================");
        schoolList.forEach(school -> {
            System.out.println(school.toString());
            subjectList.forEach(subject -> {
                double average = classOfSchoolList.parallelStream().filter(classOfSchool -> classOfSchool.getSchoolId() == school.getSchoolId())
                        .mapToDouble(classOfSchool -> studentList.parallelStream()
                                .filter(student -> classOfSchool.getClassId() == student.getClassId())
                                .mapToDouble(student -> studentSubjectRegisterList.parallelStream()
                                        .filter(studentSubjectRegister ->
                                                studentSubjectRegister.getStudentId() == student.getStudentId()
                                                        && studentSubjectRegister.getSubjectId() == subject.getSubjectId())
                                        .mapToDouble(StudentSubjectRegister::getScore)
                                        .summaryStatistics().getAverage())
                                .filter(v -> v != 0).summaryStatistics().getAverage())
                        .filter(v -> v != 0).summaryStatistics().getAverage();

                if (average != 0) {
                    System.out.println(subject.toString() + " average: " + average);
                }
            });
        });


        // Excercise 2.3: get class having the highest average score in school
        System.out.println("======================== EXCERCISE 2.3 =========================");
        schoolList.forEach(school -> {
            System.out.println(school.toString());
            final ClassOfSchool[] classMax = new ClassOfSchool[1];
            final double[] max = {-1};
            classOfSchoolList.stream().filter(classOfSchool -> classOfSchool.getSchoolId() == school.getSchoolId())
                    .forEach(classOfSchool -> {
                        double average = studentList.stream()
                                .filter(student -> student.getClassId() == classOfSchool.getClassId())
                                .mapToDouble(student -> studentSubjectRegisterList.stream()
                                        .filter(subjectRegister -> subjectRegister.getStudentId() == student.getStudentId())
                                        .mapToDouble(subjectRegister -> subjectRegister.getScore())
                                        .filter(v -> v != 0).summaryStatistics().getAverage())
                                .filter(v -> v!=0).summaryStatistics().getAverage();
                        if(average > max[0]){
                            max[0] = average;
                            classMax[0] = classOfSchool;
                        }
                    });

            System.out.println(classMax[0].toString() + ", average: " + max[0]);
        });


        //Excercise 2.4 Get ten best students and ten worst students in each subject
        System.out.println("=========================== EXCERCISE 2.4 =====================");
        subjectList.forEach(subject -> {
            System.out.println(subject.toString());
            System.out.println("10 best students: ");
            studentSubjectRegisterList.stream().filter(studentSubjectRegister -> studentSubjectRegister.getSubjectId() == subject.getSubjectId())
                    .sorted((s1, s2) -> s2.getScore().compareTo(s1.getScore())).limit(10)
                    .forEach(studentSubjectRegister -> studentList.stream()
                            .filter(student -> studentSubjectRegister.getStudentId() == student.getStudentId())
                            .forEach(student -> System.out.println(student.toString() + "score: " + studentSubjectRegister.getScore())));

            System.out.println("10 worst students: ");
            studentSubjectRegisterList.stream().filter(studentSubjectRegister -> studentSubjectRegister.getSubjectId() == subject.getSubjectId())
                    .sorted((s1, s2) -> s1.getScore().compareTo(s2.getScore())).limit(10)
                    .forEach(studentSubjectRegister -> studentList.stream()
                            .filter(student -> studentSubjectRegister.getStudentId() == student.getStudentId())
                            .forEach(student -> System.out.println(student.toString() + "score: " + studentSubjectRegister.getScore())));
        });

        //Excercise 2.5: find class having the highest average of score of each subject domain
        System.out.println("============================ EXCERCISE 2.5 ==========================");
        subjectDomainList.forEach(subjectDomain -> {
            final double[] max = {-1};
            final ClassOfSchool[] classMax = new ClassOfSchool[1];
            System.out.println(subjectDomain.toString());
            classOfSchoolList.forEach(classOfSchool -> {
                double average = studentList.stream()
                        .filter(student -> student.getClassId() == classOfSchool.getClassId())
                        .mapToDouble(student -> subjectList.stream()
                                .filter(subject -> subject.getSubjectDomain() == subjectDomain)
                                .mapToDouble(subject -> studentSubjectRegisterList.stream()
                                        .filter(subjectRegister -> subjectRegister.getSubjectId() == subject.getSubjectId() &&
                                                subjectRegister.getStudentId() == student.getStudentId())
                                        .mapToDouble(StudentSubjectRegister::getScore)
                                        .filter(v -> v != 0)
                                        .summaryStatistics().getAverage())
                                .filter(v -> v != 0)
                                .summaryStatistics().getAverage())
                        .filter(v -> v != 0)
                        .summaryStatistics().getAverage();

                if (average > max[0]) {
                    max[0] = average;
                    classMax[0] = classOfSchool;
                }

            });

            System.out.println("Class having best average: " + classMax[0].toString() + " avg: " + max[0]);


        });


        /*
        Excercise 2.6: get subjectDomain having the best average of score in school,
                        get subjectDomain having student regist most
        */

        System.out.println("===================== EXCERCISE 2.6 =========================");
        // get subjectDomain having the best average of score in school
        schoolList.forEach(school -> {
            System.out.println(school.toString());
            final double[] max = {-1};
            final SubjectDomain[] subjectDomainMax = new SubjectDomain[1];
            subjectDomainList.forEach(subjectDomain -> {
                double average = classOfSchoolList.stream().filter(classOfSchool -> classOfSchool.getSchoolId() == school.getSchoolId())
                        .mapToDouble(classOfSchool -> studentList.stream()
                                .filter(student -> student.getClassId() == classOfSchool.getClassId())
                                .mapToDouble(student -> subjectList.stream()
                                        .filter(subject -> subject.getSubjectDomain() == subjectDomain)
                                        .mapToDouble(subject -> studentSubjectRegisterList.stream()
                                                .filter(subjectRegister -> subjectRegister.getSubjectId() == subject.getSubjectId()
                                                        && subjectRegister.getStudentId() == student.getStudentId())
                                                .mapToDouble(studentSubjectRegister -> studentSubjectRegister.getScore()).summaryStatistics().getAverage())
                                        .filter(v -> v != 0).summaryStatistics().getAverage()).filter(v -> v != 0).summaryStatistics().getAverage())
                        .filter(v -> v != 0).summaryStatistics().getAverage();
//                System.out.println(subjectDomain.toString() + " avg: " + average);
                if (average > max[0]) {
                    max[0] = average;
                    subjectDomainMax[0] = subjectDomain;
                }
            });

            System.out.println(subjectDomainMax[0].toString() + " avg score: " + max[0]);
        });

        //get subjectDomain having student regist most
        final int[] numStudentMax = {0};
        final SubjectDomain[] subjectDomainMax = new SubjectDomain[1];
        subjectDomainList.forEach(subjectDomain -> {
            int sum = subjectList.stream().filter(subject -> subject.getSubjectDomain() == subjectDomain)
                    .mapToInt(subject -> (int) studentSubjectRegisterList.stream()
                            .filter(studentSubjectRegister -> studentSubjectRegister.getSubjectId() == subject.getSubjectId())
                            .count()).sum();
            if (sum >= numStudentMax[0]) {
                numStudentMax[0] = sum;
                subjectDomainMax[0] = subjectDomain;
            }
        });
        System.out.println("SubjectDomain Max is: " + subjectDomainMax[0].toString() + " ,number of students: " + numStudentMax[0]);


    }


}
