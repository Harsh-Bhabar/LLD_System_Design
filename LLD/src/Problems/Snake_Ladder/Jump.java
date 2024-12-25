package Problems.Snake_Ladder;

public abstract class Jump {
    int startPos;
    int endPos;

    public Jump(int startPos, int endPos){
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public abstract void applyEffect(Player player);

    public int getStartPos() {
        return startPos;
    }


    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }
}
