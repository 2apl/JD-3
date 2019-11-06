package com.starwars.demo.builders;

import com.starwars.demo.spaceship.Combat;
import com.starwars.demo.spaceship.Cruiser;
import com.starwars.demo.spaceship.CruiserSpaceShip;

public class CruiserSpaceShipBuilder extends SpaceShipBaseBuilder implements Combat, Cruiser {

    private int gunsNumber;
    private int firePower;

    @Override
    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    @Override
    public void setGunsNumber(int gunsNumber) {
        this.gunsNumber = gunsNumber;
    }

    @Override
    public CruiserSpaceShip build() {
        return new CruiserSpaceShip(getArmor(), getFuel(), getFuelType(), getName(), gunsNumber, firePower);
    }

}
