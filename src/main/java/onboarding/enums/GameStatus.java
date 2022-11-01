package onboarding.enums;

public enum GameStatus {

    WIN_POBI(1),
    WIN_CRONG(2),
    DRAW_GAME(0),
    EXCEPTION(-1);

    private final int value;

    GameStatus(int value) {
        this.value = value;
    }

    public static GameStatus getResultOfGame(int pobiScore, int crongScore) {
        if (pobiScore != crongScore) return pobiScore > crongScore ? WIN_POBI : WIN_CRONG;
        return DRAW_GAME;
    }

    public int getValue() {
        return value;
    }
}
