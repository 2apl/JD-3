package com.starwars.demo.factory;

import java.util.Map;

import com.starwars.demo.builders.TransportSpaceShipBuilder;
import com.starwars.demo.spaceship.TransportSpaceShip;
import com.starwars.demo.util.SpaceShipProperties;
import org.springframework.stereotype.Component;

@Component("transport")
public class TransportFactory implements SpaceShipFactory {

    @Override
    public TransportSpaceShip createSpaceShip(Map<String, Object> parameters) {
        TransportSpaceShipBuilder builder = setBaseSpaceShipsParameters(parameters, new TransportSpaceShipBuilder());
        builder.setCapacity((int) parameters.get(SpaceShipProperties.CAPACITY));
        builder.setColor((String) parameters.get(SpaceShipProperties.COLOR));

        return builder.build();
    }

}
