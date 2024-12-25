package Problems.Snake_Ladder;

public class Ladder extends Jump{
    public Ladder(int startPos, int endPos){
        super(startPos, endPos);
    }

    @Override
    public void applyEffect(Player player){
        System.out.println("Ladder! moving up from " + startPos + " to " + endPos);
        player.setCurrPos(startPos);
    }
}
