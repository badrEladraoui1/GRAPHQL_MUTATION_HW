package com.eladr.data_rest.service;

import com.eladr.data_rest.dtos.StudentDtoMutation;
import com.eladr.data_rest.entity.Centre;
import com.eladr.data_rest.entity.Student;
import com.eladr.data_rest.repository.CentreRepo;
import com.eladr.data_rest.repository.StudentRepo;
import com.eladr.data_rest.mappers.StudentDtoToStudent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    private CentreRepo centreRepo;

    public StudentService(StudentRepo studentRepo, CentreRepo centreRepo) {
        this.studentRepo = studentRepo;
        this.centreRepo = centreRepo;
    }

    public Student getSudentById(Long id) {
        return  studentRepo.findById(id).orElseThrow( () ->
                new RuntimeException(String.format("no student found by this id :" + id)));    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public String addStudent(StudentDtoMutation studentDto) {
        Centre centre = centreRepo.findById(studentDto.idCenter()).orElse(null);
        if(centre != null){
            Student student1 = Student.builder().
                    firstName(studentDto.firstName())
                    .lastName(studentDto.lastName())
                    .gender(studentDto.gender())
                    .centre(centre)
                    .build();

            studentRepo.save(student1);
            return "Added !!!";
        }
        return null;
    }

    public String updateStudent( StudentDtoMutation studentDto ,  Long id){
        Student updatedStudent = studentRepo.findById(id).orElse(null);
        if(updatedStudent != null){
            studentRepo.save(StudentDtoToStudent.toStudent(studentDto));
            return "updated !!!";
        }
        return null;
    }


    public String deleteStudent(Long id) {
        Student student = studentRepo.findById(id).orElse(null);
        if(student != null){
            studentRepo.delete(student);
            return "deleted !!!";
        }
        return null;
    }

}
