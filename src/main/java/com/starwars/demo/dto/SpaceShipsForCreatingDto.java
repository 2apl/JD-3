package com.starwars.demo.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SpaceShipsForCreatingDto {

    String type;
    List<Map<String, Object>> parameters;
}
