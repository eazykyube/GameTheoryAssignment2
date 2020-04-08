import java.util.ArrayList;

public class Main {

    static double funct(int x){
        return ((10 * Math.pow(Math.E, x)) / (1 + Math.pow(Math.E, x)));
    }

    static ArrayList<Double> playGame(Player a, Player b){
        ArrayList<Double> scores = new ArrayList<>();
        int[] x = new int[3];

        int n = 10; // Number of rounds

        int lastMoveA = 0, lastMoveB = 0;
        double scoreA = 0, scoreB = 0;

        for(int i = 0; i < n; i++){
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
        return scores;
    }

    static ArrayList<Double> playTournament(ArrayList<Player> players){
        ArrayList<Double> scores = new ArrayList<>();

        for (int i = 0; i < players.size(); i++)
            scores.add(0.0);
        for(int k = 0; k < 10; k++){
            for(int i = 0; i < players.size() - 1; i++){
                for(int j = i + 1; j < players.size(); j++){
                    ArrayList<Double> gameResult = playGame(players.get(i), players.get(j));
                    scores.set(i, scores.get(i) + gameResult.get(0));
                    scores.set(j, scores.get(j) + gameResult.get(1));
                }
            }
        }
        return scores;
    }


    public static void main(String[] args) {
        Player a = new AlwaysFirstFieldAgent();
        Player b = new GreedyAgent();
        Player c = new RandomAgent();
        ArrayList<Player> players = new ArrayList<>();
        players.add(a); players.add(b); players.add(c);
        ArrayList<Double> scores = playTournament(players);
        System.out.println("AlwaysFirstField " + scores.get(0));
        System.out.println("Greedy " + scores.get(1));
        System.out.println("Random " + scores.get(2));
    }
}
