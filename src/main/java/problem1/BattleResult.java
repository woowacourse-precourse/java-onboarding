package problem1;

public enum BattleResult {
    WIN(1), LOSE(2), DRAW(0);

    private final int code;
    BattleResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
