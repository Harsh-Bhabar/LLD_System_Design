package Problems.Snake_Ladder;

import java.util.*;

public class Board {
    int size;
    Map<Integer, Jump> jumps;
    int winningPosition;

    public Board(int size, List<Jump> jumpList){
        this.size = size;
        this.jumps = new HashMap<>();
        for(Jump jump: jumpList){
            this.jumps.put(jump.getStartPos(), jump);
        }
    }

    public int getWinningPosition() {
        return winningPosition;
    }

    public int movePlayer(Player player, int diceRoll){
        int newPos = player.getCurrPos() + diceRoll;
        if(jumps.containsKey(newPos)){
            jumps.get(newPos).applyEffect(player);
        }
        return Math.min(newPos, 100);
    }

}
