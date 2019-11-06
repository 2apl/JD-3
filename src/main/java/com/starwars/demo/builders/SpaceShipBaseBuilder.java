package com.starwars.demo.builders;

import lombok.Getter;

@Getter
public abstract class SpaceShipBaseBuilder implements SpaceShipBuilder {

    private int armor;
    private int fuel;
    private String fuelType;
    private String name;

    @Override
    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
