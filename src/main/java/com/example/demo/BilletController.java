package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BilletController {

    @Autowired
    BilletRepository rep;

    //public final List<Billett> alleBilletter = new ArrayList<>();

    @PostMapping ("/lagre") //lagre all dataen inn i et array
    public void lagreBillet(Billett innBillett){
        rep.lagreBillet(innBillett);
    }

    @GetMapping("/hentAlle")//sender "alleBilletter" tibake for omforming i Javascript
    public List<Billett> hentAlle(){
        return rep.alleBilletter();
    }

    @GetMapping("/slettAlle") // sletter alle objektene i arrayet
    public void slettAlle(){
        rep.slettAlleBilletter();
    }
}
