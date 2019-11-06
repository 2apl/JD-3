package com.starwars.demo.spaceship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SpyProbeSpaceShip extends SpaceShip {

    private String scanSensor;
    private String color;

    public SpyProbeSpaceShip(int armor, int fuel, String fuelType, String name, String color, String scanSensor) {
        setArmor(armor);
        setFuel(fuel);
        setFuelType(fuelType);
        setName(name);
        setColor(color);
        setScanSensor(scanSensor);
    }

}
