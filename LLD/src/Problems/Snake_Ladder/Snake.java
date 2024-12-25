package Problems.Snake_Ladder;

public class Snake extends Jump{
    public Snake(int startPos, int endPos){
        super(startPos, endPos);
    }

    @Override
    public void applyEffect(Player player){
        System.out.println("Snake! Moving down from " + startPos + " to " + endPos);
        player.setCurrPos(endPos);
    }
}
