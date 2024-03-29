package com.cinemadice.tmdbapi.model.credits;

import lombok.Data;

import java.util.List;

@Data
public class Credits {

    private int id;
    private List<Cast> cast;
    private List<Crew> crew;

}
