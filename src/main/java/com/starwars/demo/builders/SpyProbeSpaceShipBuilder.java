package com.starwars.demo.builders;

import com.starwars.demo.spaceship.NonCombat;
import com.starwars.demo.spaceship.SpyProbe;
import com.starwars.demo.spaceship.SpyProbeSpaceShip;

public class SpyProbeSpaceShipBuilder extends SpaceShipBaseBuilder implements NonCombat, SpyProbe {

    private String color;
    private String scanSensor;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setScanSensor(String scanSensor) {
        this.scanSensor = scanSensor;
    }

    @Override
    public SpyProbeSpaceShip build() {
        return new SpyProbeSpaceShip(getArmor(), getFuel(), getFuelType(), getName(), color, scanSensor);
    }

}
