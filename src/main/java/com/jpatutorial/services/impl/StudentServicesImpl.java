package com.jpatutorial.services.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.jpatutorial.dto.DtoStudent;
import com.jpatutorial.dto.DtoStudentIU;
import com.jpatutorial.entities.Student;
import com.jpatutorial.repository.StudentRepository;
import com.jpatutorial.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        DtoStudent response = new DtoStudent();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<Student> student = studentRepository.findAllStudentsSQL();
        List<DtoStudent> response = new ArrayList<>();
        student.forEach(e -> {
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(e, dto);
            response.add(dto);
        });

        return response;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        Optional<Student> opt = studentRepository.findStudentById(id);
        if (opt.isPresent()) {
            DtoStudent response = new DtoStudent();
            BeanUtils.copyProperties(opt.get(), response);
            return response;
        }
        return null;
    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> opt = studentRepository.findById(id);
        if (opt.isPresent()) {
            studentRepository.delete(opt.get());
        }
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU updateStudent) {
        Optional<Student> opt = studentRepository.findById(id);
        if (opt.isPresent()) {
            DtoStudent response = new DtoStudent();
            BeanUtils.copyProperties(updateStudent, opt.get());
            studentRepository.save(opt.get());
            BeanUtils.copyProperties(opt.get(), response);
            return response;
        }
        return null;
    }
}
