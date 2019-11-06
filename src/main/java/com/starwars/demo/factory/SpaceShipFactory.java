package com.starwars.demo.factory;

import java.util.Map;

import com.starwars.demo.builders.SpaceShipBuilder;
import com.starwars.demo.spaceship.SpaceShip;
import com.starwars.demo.util.SpaceShipProperties;

public interface SpaceShipFactory {

    SpaceShip createSpaceShip(Map<String, Object> parameters);

    default <T extends SpaceShipBuilder> T setBaseSpaceShipsParameters(Map<String, Object> parameters, T builder) {
        builder.setArmor((int) parameters.get(SpaceShipProperties.ARMOR));
        builder.setFuel((int) parameters.get(SpaceShipProperties.FUEL));
        builder.setFuelType((String) parameters.get(SpaceShipProperties.FUEL_TYPE));
        builder.setName((String) parameters.get(SpaceShipProperties.NAME));

        return builder;
    }
}
