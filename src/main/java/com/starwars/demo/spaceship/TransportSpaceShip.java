package com.starwars.demo.spaceship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransportSpaceShip extends SpaceShip {

    private int capacity;
    private String color;

    public TransportSpaceShip(int armor, int fuel, String fuelType, String name, int capacity, String color) {
        setArmor(armor);
        setFuel(fuel);
        setFuelType(fuelType);
        setName(name);
        setCapacity(capacity);
        setColor(color);
    }

}
