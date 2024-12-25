package Problems.Snake_Ladder;

import java.util.Random;

public class Dice {
    int diceCount;

    Dice(int diceCount){
        this.diceCount = diceCount;
    }

    public int rollDice(){
        int sum = 0;
        Random random = new Random();
        for(int i=0; i<diceCount; i++){
            sum += random.nextInt(6) + 1;
        }
        return sum;
    }
}
