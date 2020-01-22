package com.cinemadice.tmdbapi;

import java.util.Random;

public class Utils {

    public static int generateRandomNr(int lowerbound, int upperbound) {
        return new Random().nextInt(upperbound - lowerbound) + lowerbound;
    }

}
