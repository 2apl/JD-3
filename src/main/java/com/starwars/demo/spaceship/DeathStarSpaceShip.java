package com.starwars.demo.spaceship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeathStarSpaceShip extends SpaceShip {

    private int maxFightersCapacity;
    private int firePower;

    public DeathStarSpaceShip(int armor, int fuel, String fuelType, String name, int maxFightersCapacity, int firePower) {
        setArmor(armor);
        setFuel(fuel);
        setFuelType(fuelType);
        setName(name);
        setMaxFightersCapacity(maxFightersCapacity);
        setFirePower(firePower);
    }

}
