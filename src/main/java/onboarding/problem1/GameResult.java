package onboarding.problem1;

public enum GameResult {
    PLAYER1_WIN(1),
    PLAYER2_WIN(2),
    DRAW(0),
    EXCEPTION(-1);

    private final int code;

    GameResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
