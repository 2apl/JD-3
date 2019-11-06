package com.starwars.demo.builders;

import com.starwars.demo.spaceship.SpaceShip;

public interface SpaceShipBuilder {

    void setArmor(int armor);

    void setFuel(int fuel);

    void setFuelType(String fuelType);

    void setName(String name);

    SpaceShip build();
}
