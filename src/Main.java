import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import com.company.*;

public class Main {

    final static int NUMBER_OF_GAMES = 10;
    final static int NUMBER_OF_TOURNAMENTS = 100;

    static double funct(int x){
        return ((10 * Math.pow(Math.E, x)) / (1 + Math.pow(Math.E, x))); // Equation of vegetation growth
    }

    static void sortPlayers(ArrayList<Player> players, ArrayList<Double> scores){ // Sorting players for further evolution
        for(int i = 0; i < players.size() - 1; i++){
            for(int j = 0; j < players.size() - i - 1; j++){
                if(scores.get(j) < scores.get(j + 1)) {
                    Collections.swap(players, j, j + 1);
                    Collections.swap(scores, j, j + 1);
                }
            }
        }
    }

    static void evolution(ArrayList<Player> players){ // Dropping worst 5 players and replacing them with 5 best ones
        for(int i = 0; i < 5; i++){
            players.remove(players.size() - 1);
            players.add(players.get(0));
        }
    }

    static ArrayList<Double> playGame(Player a, Player b){ // Play game between two players NUMBER_OF_GAMES times
        ArrayList<Double> scores = new ArrayList<>();
        int[] x = new int[3];

        int lastMoveA = 0, lastMoveB = 0;
        double scoreA = 0, scoreB = 0;

        for(int i = 0; i < NUMBER_OF_GAMES; i++){
            int moveA = a.move(lastMoveB, x[0], x[1], x[2]);
            lastMoveA = moveA;
            int moveB = b.move(lastMoveA, x[0], x[1], x[2]);
            lastMoveB = moveB;

            if(moveA != moveB){
                scoreA += funct(x[moveA - 1]) - funct(0);
                scoreB += funct(x[moveB - 1]) - funct(0);
            }

            for(int j = 0; j < 3; j++){
                if(j != (moveA - 1) && j != (moveB - 1))
                    x[j] += 1;
                else
                    x[j] = Math.max(0, x[j] - 1);
            }
        }
        scores.add(scoreA);
        scores.add(scoreB);
        return scores; // Return final scores
    }

    static void playTournament(ArrayList<Player> players){ // Between given players play tournament NUMBER_OF_TOURNAMENTS times
        ArrayList<Double> scores = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            scores.add(0.0);
            players.get(i).reset();
        }
        for(int k = 0; k < NUMBER_OF_TOURNAMENTS; k++){
            for (int i = 0; i < players.size(); i++)
                scores.set(i, 0.0);
            for(int i = 0; i < players.size() - 1; i++){
                for(int j = i + 1; j < players.size(); j++){
                    ArrayList<Double> gameResult = playGame(players.get(i), players.get(j));
                    scores.set(i, scores.get(i) + gameResult.get(0));
                    scores.set(j, scores.get(j) + gameResult.get(1));
                }
            }
            sortPlayers(players, scores); // Sorting players
            evolution(players); // Making evolution
        }
        for(int i = 0; i < players.size(); i++){
            System.out.println(players.get(i).getClass().getName() + ": " + scores.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>(); // Here is a tournament between all players
        for(int i = 0; i < 10; i++) players.add(new AlwaysFirstFieldAgent());
        for(int i = 0; i < 10; i++) players.add(new GreedyAgent());
        for(int i = 0; i < 10; i++) players.add(new RandomAgent());
        for(int i = 0; i < 10; i++) players.add(new EnesAyanCode());
        playTournament(players);
    }
}

