package problem1;

public enum GameResultStatus {
    POBI_WIN(1), CRONG_WIN(2), DRAW(0);

    private final int status;

    GameResultStatus(int status) {
        this.status = status;
    }
}
