package problem1;

public enum Winner {
    POBI_WIN(1),
    CRONG_WIN(2),
    DRAW(0),
    ;
    
    private final int result;

    Winner(int result) {
        this.result = result;
    }

    public static Winner of(int score1, int score2) {
        if (score1 > score2) {
            return POBI_WIN;
        }
        if (score1 < score2) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    public int getResult() {
        return result;
    }
}
