package com.starwars.demo.builders;

import com.starwars.demo.spaceship.NonCombat;
import com.starwars.demo.spaceship.Transport;
import com.starwars.demo.spaceship.TransportSpaceShip;

public class TransportSpaceShipBuilder extends SpaceShipBaseBuilder implements Transport, NonCombat {

    private int capacity;
    private String color;

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public TransportSpaceShip build() {
        return new TransportSpaceShip(getArmor(), getFuel(), getFuelType(), getName(), capacity, color);
    }

}
