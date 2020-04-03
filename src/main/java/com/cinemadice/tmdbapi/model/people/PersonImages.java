package com.cinemadice.tmdbapi.model.people;

import lombok.Data;

import java.util.List;

@Data
public class PersonImages {

    private int id;
    private List<Profile> profiles;

}
