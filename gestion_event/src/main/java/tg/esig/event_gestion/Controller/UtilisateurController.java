package tg.esig.event_gestion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tg.esig.event_gestion.component.Test;
import tg.esig.event_gestion.component.UtilisateurComponent;
import tg.esig.event_gestion.model.Utilisateur;

import java.util.List;

@Controller
public class UtilisateurController {
    private Test test;
    private UtilisateurComponent utilisateurComponent;

    public UtilisateurController(Test test, UtilisateurComponent utilisateurComponent) {
        this.test = test;
        this.utilisateurComponent = utilisateurComponent;
    }

    @GetMapping("/getUtilisateur")
    public String getUtilisateur(Model model){
        List<Utilisateur> utilisateurs = test.getInfo();
        model.addAttribute("listUtilisateur", utilisateurs);
        return "utilisateur";
    }

    @GetMapping("/insertUtilisateur")
    public String insertUtilisateur(String nom, String prenom, int age, String location, RedirectAttributes redirectAttributes){
        if (nom.isEmpty() || prenom.isEmpty() || location.isEmpty() || age == 0){
            redirectAttributes.addFlashAttribute("save_error", "Echec saisie");
            return "redirect:/getUtilisateur";
        }else {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(nom);
            utilisateur.setPrenom(prenom);
            utilisateur.setAge(age);
            utilisateur.setLocation(location);
            Utilisateur utilisateurSave = utilisateurComponent.ajoutUtilisateur(utilisateur);
            redirectAttributes.addFlashAttribute("save_success", "Saisie Validée avec succès");
            return "redirect:/getUtilisateur";
        }
    }

    @GetMapping("/updateUtilisateur")
    public String updateUtilisateur(Long id, String nom, String prenom, int age, String location, RedirectAttributes redirectAttributes){
        if (nom.isEmpty() || prenom.isEmpty() || location.isEmpty() || age == 0){
            redirectAttributes.addFlashAttribute("save_error", "Echec saisie");
            return "redirect:/getUtilisateur";
        }else {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(id);
            utilisateur.setNom(nom);
            utilisateur.setPrenom(prenom);
            utilisateur.setAge(age);
            utilisateur.setLocation(location);
            Utilisateur utilisateurUpdate = utilisateurComponent.updateUtilisateur(utilisateur);
            redirectAttributes.addFlashAttribute("save_update", "Mis à jour éffectuer avec succès");
            return "redirect:/getUtilisateur";
        }
    }

    @GetMapping("/deleteUtilisateur")
    public String deleteUtilisateur(Long id,  RedirectAttributes redirectAttributes){
        utilisateurComponent.deleteUtilisateur(id);
        redirectAttributes.addFlashAttribute("delete_success", "Suppression éffectuer avec succès");
        return "redirect:/getUtilisateur";
    }
}
