package com.company;

import java.util.Random;

public class AlwaysFirstFieldAgent implements Player{

    public void reset(){}

    public int move(int opponentLastMove, int xA, int xB, int xC){ // Always select first field
        return 1;
    }
}





