package onboarding.problem1;

public enum Result {
    EXCEPTION(-1),
    DRAW(0),
    POBI_WIN(1),
    CRONG_WIN(2);

    private final int value;
    Result(int value) { this.value = value; }
    public int getValue() { return value; }
}
