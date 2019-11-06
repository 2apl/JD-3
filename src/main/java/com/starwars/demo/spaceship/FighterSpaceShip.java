package com.starwars.demo.spaceship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FighterSpaceShip extends SpaceShip {

    private int firePower;
    private int flightSpeed;

    public FighterSpaceShip(int armor, int fuel, String fuelType, String name, int firePower, int flightSpeed) {
        setArmor(armor);
        setFuel(fuel);
        setFuelType(fuelType);
        setName(name);
        setFirePower(firePower);
        setFlightSpeed(flightSpeed);
    }

}
