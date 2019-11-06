package com.starwars.demo.spaceship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TransportSpaceShip.class, name = "transport"),
        @JsonSubTypes.Type(value = FighterSpaceShip.class, name = "fighter"),
        @JsonSubTypes.Type(value = CruiserSpaceShip.class, name = "cruiser"),
        @JsonSubTypes.Type(value = DeathStarSpaceShip.class, name = "death star"),
        @JsonSubTypes.Type(value = SpyProbeSpaceShip.class, name = "spy probe")
})
public abstract class SpaceShip {

    private int armor;
    private int fuel;
    private String fuelType;
    private String name;

}
