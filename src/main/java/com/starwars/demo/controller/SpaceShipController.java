package com.starwars.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.demo.dto.SpaceShipsForCreatingDto;
import com.starwars.demo.factory.SpaceShipFactory;
import com.starwars.demo.spaceship.SpaceShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/spaceships")
public class SpaceShipController {

    private ApplicationContext context;

    @Autowired
    public SpaceShipController(ApplicationContext context) {
        this.context = context;
    }

    @PostMapping("/create-factory")
    public List<SpaceShip> createSpaceShipsByFactory(@RequestBody SpaceShipsForCreatingDto[] spaceShipsForCreatingArray) {
        List<SpaceShip> createdSpaceShips = new ArrayList<>();

        for (SpaceShipsForCreatingDto parametersDto : spaceShipsForCreatingArray) {
            List<Map<String, Object>> spaceShipParameters = parametersDto.getParameters();
            String spaceShipType = parametersDto.getType();
            SpaceShipFactory factory = context.getBean(spaceShipType, SpaceShipFactory.class);

            Map<String, Object> resultParameterMap = addAllParametersToOneMap(spaceShipParameters);
            SpaceShip spaceShip = factory.createSpaceShip(resultParameterMap);
            createdSpaceShips.add(spaceShip);
        }

        return createdSpaceShips;
    }

    @PostMapping("/create-jackson")
    public List<SpaceShip> createSpaceShipByJackson(@RequestBody SpaceShipsForCreatingDto[] spaceShipsForCreatingArray) {
        List<SpaceShip> createdSpaceShips = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (SpaceShipsForCreatingDto parametersDto : spaceShipsForCreatingArray) {
            List<Map<String, Object>> parameters = parametersDto.getParameters();
            String type = parametersDto.getType();

            Map<String, Object> parametersMap = addAllParametersToOneMap(parameters);
            parametersMap.put("@type", type);
            try {
                String parametersJson = objectMapper.writeValueAsString(parametersMap);
                SpaceShip spaceShip = objectMapper.readValue(parametersJson, SpaceShip.class);
                createdSpaceShips.add(spaceShip);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return createdSpaceShips;
    }

    private Map<String, Object> addAllParametersToOneMap(List<Map<String, Object>> spaceShipParameters) {
        Map<String, Object> resultParameterMap = new HashMap<>();
        for (Map<String, Object> parameter : spaceShipParameters) {
            resultParameterMap.putAll(parameter);
        }
        return resultParameterMap;
    }

}
