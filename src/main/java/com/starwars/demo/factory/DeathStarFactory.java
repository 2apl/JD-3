package com.starwars.demo.factory;

import java.util.Map;

import com.starwars.demo.builders.DeathStarSpaceShipBuilder;
import com.starwars.demo.spaceship.DeathStarSpaceShip;
import com.starwars.demo.util.SpaceShipProperties;
import org.springframework.stereotype.Component;

@Component("death star")
public class DeathStarFactory implements SpaceShipFactory {

    @Override
    public DeathStarSpaceShip createSpaceShip(Map<String, Object> parameters) {
        DeathStarSpaceShipBuilder builder = setBaseSpaceShipsParameters(parameters, new DeathStarSpaceShipBuilder());
        builder.setMaxFightersCapacity((int) parameters.get(SpaceShipProperties.MAX_FIGHTERS_CAPACITY));
        builder.setFirePower((int) parameters.get(SpaceShipProperties.FIRE_POWER));

        return builder.build();
    }

}
