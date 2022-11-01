package onboarding.problem1;

public enum GameResults {
    DRAW(0),
    FIRST_PLAYER_WIN(1),
    LAST_PLAYER_WIN(2),
    ILLEGAL_PAGE(-1);

    private final int GAME_RESULT;

    GameResults(int GAME_RESULT) {
        this.GAME_RESULT = GAME_RESULT;
    }

    public int gameResult() {
        return GAME_RESULT;
    }
}
