package Problems.Chess_Game.Model;

public class Player {
    public String name;
    public Piece piece;

    public Player(String name, Piece piece){
        this.name = name;
        this.piece = piece;
    }
}