package com.company;

import java.util.Random;

public class RandomAgent implements Player {

    static Random random = new Random();

    public void reset(){}

    public int move(int opponentLastMove, int xA, int xB, int xC){ // Random select of the field
        return random.nextInt(3) + 1;
    }

    public String getEmail(){
        return "e.ayan@innopolis.ru";
    }
}
