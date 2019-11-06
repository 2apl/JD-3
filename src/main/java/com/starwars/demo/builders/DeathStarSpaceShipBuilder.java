package com.starwars.demo.builders;

import com.starwars.demo.spaceship.Combat;
import com.starwars.demo.spaceship.DeathStar;
import com.starwars.demo.spaceship.DeathStarSpaceShip;

public class DeathStarSpaceShipBuilder extends SpaceShipBaseBuilder implements Combat, DeathStar {

    private int maxFightersCapacity;
    private int firePower;

    @Override
    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    @Override
    public void setMaxFightersCapacity(int maxFightersCapacity) {
        this.maxFightersCapacity = maxFightersCapacity;
    }

    @Override
    public DeathStarSpaceShip build() {
        return new DeathStarSpaceShip(getArmor(), getFuel(), getFuelType(), getName(), maxFightersCapacity, firePower);
    }

}
