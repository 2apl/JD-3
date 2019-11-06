package com.starwars.demo.factory;

import java.util.Map;

import com.starwars.demo.builders.CruiserSpaceShipBuilder;
import com.starwars.demo.spaceship.CruiserSpaceShip;
import com.starwars.demo.util.SpaceShipProperties;
import org.springframework.stereotype.Component;

@Component("cruiser")
public class CruiserFactory implements SpaceShipFactory {

    @Override
    public CruiserSpaceShip createSpaceShip(Map<String, Object> parameters) {
        CruiserSpaceShipBuilder builder = setBaseSpaceShipsParameters(parameters, new CruiserSpaceShipBuilder());
        builder.setFirePower((int) (parameters.get(SpaceShipProperties.FIRE_POWER)));
        builder.setGunsNumber((int) parameters.get(SpaceShipProperties.GUNS_NUMBER));

        return builder.build();
    }

}
