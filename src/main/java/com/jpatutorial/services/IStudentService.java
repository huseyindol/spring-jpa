package com.jpatutorial.services;

import com.jpatutorial.dto.DtoStudent;
import com.jpatutorial.dto.DtoStudentIU;
import com.jpatutorial.entities.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU student);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU updateStudent);
}
