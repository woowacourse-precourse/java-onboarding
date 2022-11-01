package problem1;

public enum GameResultStatus {
    POBI_WIN(1), CRONG_WIN(2), DRAW(0);

    private final int result;

    GameResultStatus(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
