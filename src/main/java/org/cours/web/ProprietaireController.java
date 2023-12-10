package org.cours.web;

import org.cours.modele.Proprietaire;
import org.cours.modele.ProprietaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProprietaireController {
    @Autowired
    private ProprietaireRepo proprietaireRepo;
    @RequestMapping(value = "/proprietaires" , method = RequestMethod.GET)
    public Iterable<Proprietaire> getAllProprietaire(){
        return proprietaireRepo.findAll();
    }
}
