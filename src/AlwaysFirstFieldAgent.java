import java.util.Random;

public class AlwaysFirstFieldAgent implements Player{

    static Random random = new Random();

    @Override
    public void reset(){}

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC){
        return 1;
    }
}





