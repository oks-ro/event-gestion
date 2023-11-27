package tg.esig.event_gestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.esig.event_gestion.model.Evenement;

public interface EvenementRepository  extends JpaRepository<Evenement,Long> {
    Evenement findEvenementByEventname(String nom);
}
