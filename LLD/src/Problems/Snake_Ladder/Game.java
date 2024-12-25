package Problems.Snake_Ladder;

import java.util.List;

public class Game {
    Board board;
    Dice dice;
    List<Player> players;
    int currPlayerIndex = 0;

    public Game(Board board, Dice dice, List<Player> players){
        this.board = board;
        this.dice = dice;
        this.players = players;
        this.currPlayerIndex = 0;
    }

    public void startGame(){
        while(!isGameOver()){
            Player currPlayer = players.get(currPlayerIndex);
            takeTurn(currPlayer);
            currPlayerIndex = (currPlayerIndex + 1) % players.size();
        }
    }

    public boolean isGameOver(){
        return players.stream().anyMatch(player -> player.getCurrPos() == board.getWinningPosition());
    }

    public void takeTurn(Player player){
        int diceRoll = dice.rollDice();
        int newPosition = board.movePlayer(player, diceRoll);
        player.setCurrPos(newPosition);
        System.out.println("Player is not at " + newPosition);
    }

}
