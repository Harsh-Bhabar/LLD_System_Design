package Problems.Chess_Game.main;

import Problems.Chess_Game.Model.Board;
import Problems.Chess_Game.Model.Piece;
import Problems.Chess_Game.Model.PieceType;
import Problems.Chess_Game.Model.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Deque<Player> playerList;
    Board board;

    public Game() {
        init();
    }

    public void init() {
        playerList = new LinkedList<>();
        Player player1 = new Player("Harsh", new Piece(PieceType.X));
        Player player2 = new Player("Ayush", new Piece(PieceType.O));

        playerList.add(player1);
        playerList.add(player2);

        board = new Board(3); // Create a 3x3 board
    }

    public String startGame() {
        boolean gotWinner = false;
        Scanner scanner = new Scanner(System.in);

        while (!gotWinner) {
            Player player = playerList.removeFirst();
            board.printBoard();
            System.out.println(player.name + ", it's your turn!");

            boolean validMove = false;
            while (!validMove) {
                System.out.print("Enter row and column (e.g., 0 1): ");
                int i = scanner.nextInt();
                int j = scanner.nextInt();

                validMove = board.addPiece(i, j, player.piece);
                if (!validMove) {
                    System.out.println("Invalid move! Try again.");
                }
            }

            if (board.checkWinner(player.piece)) {
                board.printBoard();
                return player.name;
            }

            if (board.isFull()) {
                board.printBoard();
                return "It's a Tie!";
            }

            playerList.addLast(player); // Put the player back in the queue
        }

        return "";
    }
}
