package com.eladr.data_rest.mappers;

import com.eladr.data_rest.dtos.StudentDtoMutation;
import com.eladr.data_rest.entity.Centre;
import com.eladr.data_rest.entity.Student;
import com.eladr.data_rest.repository.CentreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoToStudent {

    @Autowired
    static CentreRepo centreRepo;

    public static Student toStudent(StudentDtoMutation studentDto){

        Centre centre = centreRepo.findById(studentDto.idCenter()).orElse(null);

        Student student = Student.builder()
                .firstName(studentDto.firstName())
                .lastName(studentDto.lastName())
                .centre(centre)
                .gender(studentDto.gender())
                .build();

        return student;
    }
}
