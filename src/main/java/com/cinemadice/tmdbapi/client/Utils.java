package com.cinemadice.tmdbapi.client;

import java.util.Random;

final class Utils {

    private Utils() {}

    static int generateRandomNr(int lowerbound, int upperbound) {
        return new Random().nextInt(upperbound - lowerbound) + lowerbound;
    }

}
