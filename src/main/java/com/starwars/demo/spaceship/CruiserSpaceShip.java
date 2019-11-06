package com.starwars.demo.spaceship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CruiserSpaceShip extends SpaceShip {

    private int gunsNumber;
    private int firePower;

    public CruiserSpaceShip(int armor, int fuel, String fuelType, String name, int gunsNumber, int firePower) {
        setArmor(armor);
        setFuel(fuel);
        setFuelType(fuelType);
        setName(name);
        setGunsNumber(gunsNumber);
        setFirePower(firePower);
    }

}
