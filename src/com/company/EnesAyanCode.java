package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class EnesAyanCode implements Player{

    static Random random = new Random();
    private int lastxA, lastxB, lastxC;
    private int opponentGreed, gamesPlayed;
    private ArrayList<Integer> lastValues, lastFields, currentValues, currentFields;

    public void reset(){
        lastxA = 1;
        lastxB = 2;
        lastxC = 3;
        opponentGreed = 0;
        gamesPlayed = 1;
        lastValues = new ArrayList<>();
        lastFields = new ArrayList<>();
        currentValues = new ArrayList<>();
        currentFields = new ArrayList<>();
        lastFields.add(1); lastFields.add(2); lastFields.add(3);
        currentFields.add(1); currentFields.add(2); currentFields.add(3);
        lastValues.add(lastxA); lastValues.add(lastxB); lastValues.add(lastxC);
    }

    public int move(int opponentLastMove, int xA, int xB, int xC){
        this.reset();
        currentValues.add(xA); currentValues.add(xB); currentValues.add(xC);
        sortFields(xA, xB, xC);
        lastxA = xA; lastxB = xB; lastxC = xC;
        if(opponentLastMove == lastFields.get(0)){
            opponentGreed += 1;
            double greedProb = opponentGreed / gamesPlayed;
            double myProb = random.nextDouble();
            if(myProb >= greedProb)
                return currentFields.get(0);
            else
                return currentFields.get(1);
        }else{
            return currentFields.get(0);
        }
    }

    public void sortFields(int xA, int xB, int xC){
        lastValues.set(0, lastxA); lastValues.set(1, lastxB); lastValues.set(2, lastxC);
        currentValues.set(0, xA); currentValues.set(1, xB); currentValues.set(2, xC);
        for(int i = 0; i < 3 - 1; i++){
            for(int j = 0; j < 3 - i - 1; j++){
                if(lastValues.get(j) < lastValues.get(j + 1)) {
                    Collections.swap(lastValues, j, j + 1);
                    Collections.swap(lastFields, j, j + 1);
                }
                if(currentValues.get(j) < currentValues.get(j + 1)) {
                    Collections.swap(currentValues, j, j + 1);
                    Collections.swap(currentFields, j, j + 1);
                }
            }
        }
    }
}
