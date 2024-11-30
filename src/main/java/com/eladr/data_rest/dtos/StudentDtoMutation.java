package com.eladr.data_rest.dtos;

import com.eladr.data_rest.enums.Gender;

public record StudentDtoMutation (

     String firstName,
     String lastName,
     Gender gender,
     Integer idCenter

){}
