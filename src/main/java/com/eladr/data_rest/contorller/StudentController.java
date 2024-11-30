package com.eladr.data_rest.contorller;

import com.eladr.data_rest.dtos.StudentDtoMutation;
import com.eladr.data_rest.entity.Student;
import com.eladr.data_rest.service.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }

    @QueryMapping
    public Student getStudentById(@Argument Long id){
        return  studentService.getSudentById(id);
    }

    @QueryMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @MutationMapping
    public String addStudent(@Argument StudentDtoMutation studentDto){
        return studentService.addStudent(studentDto);
    }

    @MutationMapping
    public String updateStudent(@Argument StudentDtoMutation studentDto , @Argument Long id){
        return studentService.updateStudent(studentDto , id);
    }

    @MutationMapping
    public String deleteStudent(@Argument Long id){
        return studentService.deleteStudent(id);
    }



}
