package com.eladr.data_rest.service;

import com.eladr.data_rest.dtos.CentreDto;
import com.eladr.data_rest.entity.Centre;
import com.eladr.data_rest.repository.CentreRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreService {

  CentreRepo centreRepo;

  public CentreService(CentreRepo centreRepo){
    this.centreRepo = centreRepo;
  }

   public Centre getCentreById(Integer id) {
        return  centreRepo.findById(id).orElseThrow( () ->
                new RuntimeException(String.format("no centre found by this id :" + id)));
    }

    public String addCentre(CentreDto centreDto){

      Centre centre = new Centre();
        centre.setNomCentre(centreDto.nomCentre());
        centre.setAddress(centreDto.address());
        centreRepo.save(centre);
        return "Added !!!";
    }

    public String updateCentre(Integer id , CentreDto centreDto){
        Centre updatedCentre = centreRepo.findById(id).orElse(null);
        if(updatedCentre != null){
            updatedCentre.setNomCentre(centreDto.nomCentre());
            updatedCentre.setAddress(centreDto.address());
            centreRepo.save(updatedCentre);
            return "updated !!!";
        }
        return null;
    }

    public String deleteCentre(Integer id) {
        Centre centre = centreRepo.findById(id).orElse(null);
        if(centre != null){
            centreRepo.delete(centre);
            return "deleted !!!";
        }
        return null;
    }

    public List<Centre> getAllCentres(){
        return centreRepo.findAll();
    }



}
