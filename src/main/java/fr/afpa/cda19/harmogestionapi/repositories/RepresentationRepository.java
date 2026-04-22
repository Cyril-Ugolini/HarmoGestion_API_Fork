package fr.afpa.cda19.harmogestionapi.repositories;

import fr.afpa.cda19.harmogestionapi.models.Representation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository permettant l'accès aux données des représentations.
 *
 * @author UGOLINI Cyril
 * @version 0.0.1
 * @since 22/04/2026
 */
@Repository
public interface RepresentationRepository extends CrudRepository<Representation, Integer> {
}