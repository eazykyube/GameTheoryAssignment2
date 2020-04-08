package com.company;

public class GreedyAgent implements Player{

    public void reset(){}

    public int move(int opponentLastMove, int xA, int xB, int xC){ // Always select the best field
        int max = Math.max(xA, (Math.max(xB, xC)));
        if(max == xA){return 1;}
        else if(max == xB){return 2;}
        else{return 3;}
    }
}
