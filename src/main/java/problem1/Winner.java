package problem1;

public enum Result {
    POBI_WIN(1),
    CRONG_WIN(2),
    DRAW(0),
    ERROR(-1);
    
    private final int result;

    Result(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public Result of(int score1, int score2) {
        if (score1 > score2) {
            return POBI_WIN;
        }
        if (score1 < score2) {
            return CRONG_WIN;
        }
        return DRAW;
    }
}
