package com.cinemadice.tmdbapi.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TvGenre {
    ACTION_AND_ADVENTURE("10759"),
    ANIMATION("16"),
    COMEDY("35"),
    CRIME("80"),
    DOCUMENTARY("99"),
    DRAMA("18"),
    FAMILY("10751"),
    KIDS("10762"),
    MYSTERY("9648"),
    NEWS("10763"),
    REALITY("10764"),
    SCIENCE_FICTION_AND_FANTASY("10765"),
    SOAP("10766"),
    TALK("10767"),
    WAR_AND_POLITICS("10768"),
    WESTERN("37");

    @Getter
    private String id;

}
