package fr.afpa.cda19.harmogestionapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Entité représentant une représentation musicale.
 *
 * @author UGOLINI Cyril
 * @version 0.0.1
 * @since 22/04/2026
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "representation")
public class Representation {

    /**
     * Identifiant unique de la représentation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_representation")
    private Integer idRepresentation;

    /**
     * Nom de la représentation.
     */
    @Column(name = "nom_representation", nullable = false, length = 80)
    @NotBlank(message = "Le nom de la représentation est obligatoire")
    @Size(max = 80, message = "Le nom ne doit pas dépasser 80 caractères")
    private String nomRepresentation;

    /**
     * Date de la représentation.
     */
    @Column(name = "date_representation", nullable = false)
    @NotNull(message = "La date de la représentation est obligatoire")
    private LocalDateTime dateRepresentation;

    /**
     * Lieu de la représentation.
     */
    @Column(name = "lieu_representation", nullable = false, length = 100)
    @NotBlank(message = "Le lieu de la représentation est obligatoire")
    @Size(max = 100, message = "Le lieu ne doit pas dépasser 100 caractères")
    private String lieuRepresentation;

    /**
     * Liste des membres participant à la représentation.
     */
    @ManyToMany
    @JoinTable(
            name = "participer_representation",
            joinColumns = @JoinColumn(name = "id_representation"),
            inverseJoinColumns = @JoinColumn(name = "id_membre")
    )
    private List<Membre> listeMembres = new ArrayList<>();

    /**
     * Liste des instruments utilisés lors de la représentation.
     */
    @ManyToMany
    @JoinTable(
            name = "instruments_representation",
            joinColumns = @JoinColumn(name = "id_representation"),
            inverseJoinColumns = @JoinColumn(name = "id_instrument")
    )
    private List<Instrument> listeInstruments = new ArrayList<>();
}