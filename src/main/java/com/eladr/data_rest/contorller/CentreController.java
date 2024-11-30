package com.eladr.data_rest.contorller;

import com.eladr.data_rest.dtos.CentreDto;
import com.eladr.data_rest.entity.Centre;
import com.eladr.data_rest.service.CentreService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CentreController {

    CentreService centreService;

    public CentreController(CentreService centreService){
        this.centreService = centreService;
    }

    @MutationMapping
    public String addCentre(@Argument CentreDto centreDto){
        return centreService.addCentre(centreDto);
    }

    @MutationMapping
    public String updateCentre(@Argument Integer id , @Argument CentreDto centreDto){
        return centreService.updateCentre(id , centreDto);
    }

    @MutationMapping
    public String deleteCentre(@Argument Integer id){
        return centreService.deleteCentre(id);
    }

    @QueryMapping
    public List<Centre> getAllCentres(){
        return centreService.getAllCentres();
    }

    @QueryMapping
    public Centre getCentreById(Integer id){
        return centreService.getCentreById(id);
    }

}
