package com.jpatutorial.repository;

import com.jpatutorial.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    Kendi özel metotlarımızı yazabiliriz.
//    HQL: Hibernate Query Language -> sınıf ismi ve değişken isimleri kullanılarak sorgular yapılır.
//    @Query(value = "from Student", nativeQuery = false(default))
//    SQL: Query Language -> tablo ismi ve kolon isimleri ile sorgular yapılır.
//    @Query(value = "from Student", nativeQuery = true)
    @Query(value = "from Student")
    List<Student> findAllStudents();

    @Query(value = "select * from student.student",nativeQuery = true)
    List<Student> findAllStudentsSQL();

    @Query(value = "from Student s WHERE s.id= :studentId")
    Optional<Student> findStudentById(Integer studentId);
}
