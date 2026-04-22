package fr.afpa.cda19.harmogestionapi.services;

import fr.afpa.cda19.harmogestionapi.models.Representation;
import fr.afpa.cda19.harmogestionapi.repositories.RepresentationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service gérant la logique métier des représentations.
 *
 * @author UGOLINI Cyril
 * @version 0.0.1
 * @since 22/04/2026
 */
@Data
@Service
public class RepresentationService {

    /**
     * Repository permettant l'accès aux données des représentations.
     */
    private RepresentationRepository representationRepository;

    /**
     * Injection du repository via setter.
     *
     * @param representationRepository le repository des représentations
     */
    @Autowired
    public void setRepresentationRepository(final RepresentationRepository representationRepository) {
        this.representationRepository = representationRepository;
    }

    /**
     * Récupère toutes les représentations.
     *
     * @return la liste de toutes les représentations
     */
    public Iterable<Representation> getAllRepresentation() {
        return representationRepository.findAll();
    }

    /**
     * Récupère une représentation par son identifiant.
     *
     * @param id l'identifiant de la représentation
     * @return la représentation correspondante, ou vide si non trouvée
     */
    public Optional<Representation> getRepresentation(final int id) {
        return representationRepository.findById(id);
    }

    /**
     * Sauvegarde ou met à jour une représentation.
     *
     * @param representation la représentation à sauvegarder
     * @return la représentation sauvegardée
     */
    public Representation saveRepresentation(final Representation representation) {
        return representationRepository.save(representation);
    }

    /**
     * Supprime une représentation par son identifiant.
     *
     * @param id l'identifiant de la représentation à supprimer
     */
    public void deleteRepresentation(final int id) {
        representationRepository.deleteById(id);
    }
}