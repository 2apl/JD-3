package com.starwars.demo.builders;

import com.starwars.demo.spaceship.Combat;
import com.starwars.demo.spaceship.Fighter;
import com.starwars.demo.spaceship.FighterSpaceShip;

public class FighterSpaceShipBuilder extends SpaceShipBaseBuilder implements Combat, Fighter {

    private int firePower;
    private int flightSpeed;

    @Override
    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    @Override
    public void setFlightSpeed(int flightSpeed) {
        this.flightSpeed = flightSpeed;
    }

    @Override
    public FighterSpaceShip build() {
        return new FighterSpaceShip(getArmor(), getFuel(), getFuelType(), getName(), firePower, flightSpeed);
    }

}
