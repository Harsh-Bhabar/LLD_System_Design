package Problems.Snake_Ladder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player(0);
        Player player2 = new Player(1);
        List<Player> players = Arrays.asList(player2, player1);

        Jump snake1 = new Snake(88, 8);
        Jump snake2 = new Snake(45, 2);
        Jump snake3 = new Snake(99, 1);
        Jump snake4 = new Snake(65, 2);

        Jump Ladder1 = new Ladder(4, 65);
        Jump Ladder2 = new Ladder(23, 87);
        Jump Ladder3 = new Ladder(76, 82);
        Jump Ladder4 = new Ladder(34, 67);

        List<Jump> jumpList = Arrays.asList(snake1, snake2, snake3, snake4, Ladder1, Ladder2, Ladder3, Ladder4);

        Board board = new Board(100, jumpList);
        Dice dice = new Dice(1);

        Game game = new Game(board, dice, players);

        game.startGame();
    }
}
