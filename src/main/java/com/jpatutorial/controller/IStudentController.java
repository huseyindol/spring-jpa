package com.jpatutorial.controller;

import com.jpatutorial.dto.DtoStudent;
import com.jpatutorial.dto.DtoStudentIU;
import com.jpatutorial.entities.Student;

import java.util.List;

public interface IStudentController {
    public DtoStudent saveStudent(DtoStudentIU student);
    public List<DtoStudent> getAllStudents();
    public DtoStudent getStudentById(Integer id);
    public void deleteStudent(Integer id);
    public DtoStudent updateStudent(Integer id, DtoStudentIU updateStudent);
}
