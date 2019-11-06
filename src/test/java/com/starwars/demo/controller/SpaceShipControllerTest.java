package com.starwars.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpaceShipControllerTest {

    private static final String URL_CREATE_FACTORY = "http://localhost:8080/api/v1/spaceships/create-factory";
    private static final String URL_CREATE_JACKSON = "http://localhost:8080/api/v1/spaceships/create-jackson";
    private static final String APPLICATION_JSON = "application/json";
    private static final String TRANSPORT_SPACE_SHIP_PARAMETERS = "{\"type\": \"transport\",\"parameters\": [{\"armor\": 100},{\"fuel\": 1000},{\"fuelType\": \"diesel\"},{\"name\": \"Victory\"},{\"capacity\": 1500},{\"color\": \"white\"}]}";
    private static final String FIGHTER_SPACE_SHIP_PARAMETERS = "{\"type\": \"fighter\",\"parameters\": [{\"armor\": 100},{\"fuel\": 1000},{\"fuelType\": \"diesel\"},{\"name\": \"Aurora\"},{\"flightSpeed\": 1200},{\"firePower\": 300}]}";
    private static final String SPY_PROBE_SPACE_SHIP_PARAMETERS = "{\"type\": \"spy probe\",\"parameters\": [{\"armor\": 100},{\"fuel\": 1000},{\"fuelType\": \"diesel\"},{\"name\": \"Aurora\"},{\"scanSensor\": \"infra\"},{\"color\": \"green\"}]}";
    private static final String DEATH_STAR_SPACE_SHIP_PARAMETERS = "{\"type\": \"death star\",\"parameters\": [{\"armor\": 100},{\"fuel\": 1000},{\"fuelType\": \"diesel\"},{\"name\": \"Aurora\"},{\"maxFightersCapacity\": 5},{\"firePower\": 150}]}";
    private static final String CRUISER_SPACE_SHIP_PARAMETERS = "{\"type\": \"cruiser\",\"parameters\": [{\"armor\": 100},{\"fuel\": 1000},{\"fuelType\": \"diesel\"},{\"name\": \"Aurora\"},{\"gunsNumber\": 10},{\"firePower\": 300}]}";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkCreatingTransportSpaceShip() {
        String factoryResult = checkSpaceShipCreating(URL_CREATE_FACTORY, Arrays.asList(TRANSPORT_SPACE_SHIP_PARAMETERS));
        String jacksonResult = checkSpaceShipCreating(URL_CREATE_JACKSON, Arrays.asList(TRANSPORT_SPACE_SHIP_PARAMETERS));
        assertTrue("The response does not contain Transport space ship", factoryResult.contains("\"@type\":\"transport\""));
        assertTrue("The response does not contain Transport space ship", jacksonResult.contains("\"@type\":\"transport\""));
    }

    @Test
    public void checkCreatingFighterSpaceShip() {
        String factoryResult = checkSpaceShipCreating(URL_CREATE_FACTORY, Arrays.asList(FIGHTER_SPACE_SHIP_PARAMETERS));
        String jacksonResult = checkSpaceShipCreating(URL_CREATE_JACKSON, Arrays.asList(FIGHTER_SPACE_SHIP_PARAMETERS));
        assertTrue("The response does not contain Fighter space ship", factoryResult.contains("\"@type\":\"fighter\""));
        assertTrue("The response does not contain Fighter space ship", jacksonResult.contains("\"@type\":\"fighter\""));
    }

    @Test
    public void checkCreatingSpyProbeSpaceShip() {
        String factoryResult = checkSpaceShipCreating(URL_CREATE_FACTORY, Arrays.asList(SPY_PROBE_SPACE_SHIP_PARAMETERS));
        String jacksonResult = checkSpaceShipCreating(URL_CREATE_JACKSON, Arrays.asList(SPY_PROBE_SPACE_SHIP_PARAMETERS));
        assertTrue("The response does not contain Spy Probe space ship", factoryResult.contains("\"@type\":\"spy probe\""));
        assertTrue("The response does not contain Spy Probe space ship", jacksonResult.contains("\"@type\":\"spy probe\""));
    }

    @Test
    public void checkCreatingDeathStarSpaceShip() {
        String factoryResult = checkSpaceShipCreating(URL_CREATE_FACTORY, Arrays.asList(DEATH_STAR_SPACE_SHIP_PARAMETERS));
        String jacksonResult = checkSpaceShipCreating(URL_CREATE_JACKSON, Arrays.asList(DEATH_STAR_SPACE_SHIP_PARAMETERS));
        assertTrue("The response does not contain Death Star space ship", factoryResult.contains("\"@type\":\"death star\""));
        assertTrue("The response does not contain Death Star space ship", jacksonResult.contains("\"@type\":\"death star\""));
    }

    @Test
    public void checkCreatingCruiserSpaceShip() {
        String factoryResult = checkSpaceShipCreating(URL_CREATE_FACTORY, Arrays.asList(CRUISER_SPACE_SHIP_PARAMETERS));
        String jacksonResult = checkSpaceShipCreating(URL_CREATE_JACKSON, Arrays.asList(CRUISER_SPACE_SHIP_PARAMETERS));
        assertTrue("The response does not contain Cruiser space ship", factoryResult.contains("\"@type\":\"cruiser\""));
        assertTrue("The response does not contain Cruiser space ship", jacksonResult.contains("\"@type\":\"cruiser\""));
    }

    @Test
    public void checkCreatingSeveralSpaceShips() {
        List<String> spaceShipsParametersList = Arrays.asList(
                TRANSPORT_SPACE_SHIP_PARAMETERS,
                FIGHTER_SPACE_SHIP_PARAMETERS,
                SPY_PROBE_SPACE_SHIP_PARAMETERS,
                DEATH_STAR_SPACE_SHIP_PARAMETERS,
                CRUISER_SPACE_SHIP_PARAMETERS);

        String factoryResult = checkSeveralSpaceShipsCreating(URL_CREATE_FACTORY, spaceShipsParametersList);
        assertTrue("The response does not contain Transport space ship", factoryResult.contains("\"@type\":\"transport\""));
        assertTrue("The response does not contain Fighter space ship", factoryResult.contains("\"@type\":\"fighter\""));
        assertTrue("The response does not contain Spy Probe space ship", factoryResult.contains("\"@type\":\"spy probe\""));
        assertTrue("The response does not contain Death Star space ship", factoryResult.contains("\"@type\":\"death star\""));
        assertTrue("The response does not contain Cruiser space ship", factoryResult.contains("\"@type\":\"cruiser\""));

        String jacksonResult = checkSeveralSpaceShipsCreating(URL_CREATE_JACKSON, spaceShipsParametersList);
        assertTrue("The response does not contain Transport space ship", factoryResult.contains("\"@type\":\"transport\""));
        assertTrue("The response does not contain Fighter space ship", jacksonResult.contains("\"@type\":\"fighter\""));
        assertTrue("The response does not contain Spy Probe space ship", jacksonResult.contains("\"@type\":\"spy probe\""));
        assertTrue("The response does not contain Death Star space ship", jacksonResult.contains("\"@type\":\"death star\""));
        assertTrue("The response does not contain Cruiser space ship", jacksonResult.contains("\"@type\":\"cruiser\""));
    }

    private String checkSeveralSpaceShipsCreating(String url, List<String> spaceShipsParametersList) {
        String content = "";
        try {
            content = mockMvc.perform(post(url).content(spaceShipsParametersList.toString()).contentType(APPLICATION_JSON))
                    .andExpect(
                            status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }

    private String checkSpaceShipCreating(String url, List<String> spaceShipParameters) {
        String content = "";
        try {
            content = mockMvc.perform(post(url).content(
                    spaceShipParameters.toString()).contentType(APPLICATION_JSON))
                    .andExpect(
                            status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }

}