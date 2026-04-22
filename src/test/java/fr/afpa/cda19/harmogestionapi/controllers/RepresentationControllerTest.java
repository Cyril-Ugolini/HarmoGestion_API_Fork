package fr.afpa.cda19.harmogestionapi.controllers;

import fr.afpa.cda19.harmogestionapi.models.Instrument;
import fr.afpa.cda19.harmogestionapi.models.Membre;
import fr.afpa.cda19.harmogestionapi.models.Representation;
import fr.afpa.cda19.harmogestionapi.services.RepresentationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests unitaires Mock du controller des représentations.
 *
 * @author UGOLINI Cyril
 * @version 0.0.1
 * @since 22/04/2026
 */
@WebMvcTest(controllers = RepresentationController.class)
class RepresentationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final Representation representation =
            new Representation(null, "Concert de printemps",
                               LocalDateTime.now(), "Salle des fêtes",
                               new ArrayList<>(), new ArrayList<>());

    @MockitoBean
    private RepresentationService representationService;

    @Test
    void getAllRepresentationTest() throws Exception {

        mockMvc.perform(get("/representations")).andExpect(status().isOk());
    }

    @Test
    void getRepresentationTest() throws Exception {

        mockMvc.perform(get("/representations/1")).andExpect(status().isOk());
    }

    @Test
    void createRepresentationTestOk() throws Exception {

        representation.getListeMembres().add(new Membre(1, "Ugolini",
                                                        "Cyril", LocalDate.now()));
        final String json = new ObjectMapper().writeValueAsString(representation);

        mockMvc.perform(post("/representations")
                                .content(json)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void createRepresentationTestKo() throws Exception {

        representation.setIdRepresentation(1);
        final String json = new ObjectMapper().writeValueAsString(representation);

        mockMvc.perform(post("/representations")
                                .content(json)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateRepresentationTest() throws Exception {

        final String json = new ObjectMapper().writeValueAsString(representation);

        mockMvc.perform(put("/representations/1")
                                .content(json)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteRepresentationTest() throws Exception {

        final String json = new ObjectMapper().writeValueAsString(representation);

        mockMvc.perform(delete("/representations/1")
                                .content(json)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}