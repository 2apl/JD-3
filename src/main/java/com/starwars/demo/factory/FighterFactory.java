package com.starwars.demo.factory;

import java.util.Map;

import com.starwars.demo.builders.FighterSpaceShipBuilder;
import com.starwars.demo.spaceship.FighterSpaceShip;
import com.starwars.demo.util.SpaceShipProperties;
import org.springframework.stereotype.Component;

@Component("fighter")
public class FighterFactory implements SpaceShipFactory {

    @Override
    public FighterSpaceShip createSpaceShip(Map<String, Object> parameters) {
        FighterSpaceShipBuilder builder = setBaseSpaceShipsParameters(parameters, new FighterSpaceShipBuilder());
        builder.setFirePower((int) parameters.get(SpaceShipProperties.FIRE_POWER));
        builder.setFlightSpeed((int) parameters.get(SpaceShipProperties.FLIGHT_SPEED));

        return builder.build();
    }

}
