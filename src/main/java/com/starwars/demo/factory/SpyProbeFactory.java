package com.starwars.demo.factory;

import java.util.Map;

import com.starwars.demo.builders.SpyProbeSpaceShipBuilder;
import com.starwars.demo.spaceship.SpyProbeSpaceShip;
import com.starwars.demo.util.SpaceShipProperties;
import org.springframework.stereotype.Component;

@Component("spy probe")
public class SpyProbeFactory implements SpaceShipFactory {

    @Override
    public SpyProbeSpaceShip createSpaceShip(Map<String, Object> parameters) {
        SpyProbeSpaceShipBuilder builder = setBaseSpaceShipsParameters(parameters, new SpyProbeSpaceShipBuilder());
        builder.setColor((String) parameters.get(SpaceShipProperties.COLOR));
        builder.setScanSensor((String) parameters.get(SpaceShipProperties.SCAN_SENSOR));

        return builder.build();
    }

}
