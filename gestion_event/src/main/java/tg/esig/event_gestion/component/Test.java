package tg.esig.event_gestion.component;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import tg.esig.event_gestion.dao.EvenementRepository;
import tg.esig.event_gestion.dao.UtilisateurRepository;
import tg.esig.event_gestion.model.Evenement;
import tg.esig.event_gestion.model.Utilisateur;

import java.util.List;

@Component
public class Test {
    private final UtilisateurRepository utilisateurRepository;
    private final EvenementRepository evenementRepository;

    public Test(UtilisateurRepository utilisateurRepository, EvenementRepository evenementRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.evenementRepository = evenementRepository;
    }

    @PostConstruct
    public void InsetsUtilisateur(){
     //   Utilisateur utilisateur= new Utilisateur();
     //   utilisateur.setNom("SALOU");
     //   utilisateur.setPrenom("Kadji");
    //    utilisateur.setAge(25);
     //   utilisateur.setLocation("Be-Kpota");
     //   Utilisateur utilisateurSave = utilisateurRepository.save(utilisateur);
      //  System.out.println("Utilisateur inserer" + utilisateurSave);
        Utilisateur utilisateur = utilisateurRepository.findNom("SALOU");
       // utilisateur.setAge(20);

      //  Utilisateur utilisateur1 = utilisateurRepository.save((utilisateur));

        System.out.println("utilisateur afficher: "+utilisateur);


    }
    //@PostConstruct
    public void InsertEvenement(){

        Evenement evenement = new Evenement();
        evenement.setEventname("Happy run");
        evenement.setAuthor("Brad Pitt");
        evenement.setEventdate("12/07/2023");
        evenement.setEventplace("baguida");
        Evenement evenementSave = evenementRepository.save(evenement);
        System.out.println("Evenement inserer:"+evenementSave );
    }
    public String afficheInfo(){
        List<Utilisateur> utilisateurs= utilisateurRepository.findAll();
        return utilisateurs.toString();
    }

    public List<Utilisateur> getInfo(){
        List<Utilisateur> utilisateurs= utilisateurRepository.findAll();
        return utilisateurs;
    }

}