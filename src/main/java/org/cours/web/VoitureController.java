package org.cours.web;

import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VoitureController {
    @Autowired
    private VoitureRepo voitureRepo;
    @RequestMapping(value = "/voitures",method = RequestMethod.GET)
    //returns a collection of "voiture" objects
    public Iterable<Voiture> getVoitures(){
        return voitureRepo.findAll();
    }

    @RequestMapping(value = "/proprietaire/{id}/voitures",method = RequestMethod.GET)
    public List<Voiture> getVoituresOfPro(@PathVariable Long id){
        List<Voiture> voitures=new ArrayList<Voiture>();
        voitureRepo.findByProprietaireId(id).forEach(voitures::add);
        return voitures;
    }


}
