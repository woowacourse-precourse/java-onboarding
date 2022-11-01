package onboarding.support.problem1;

public enum Winner {
    POBI(1), CRONG(2), TIE(0), EXCEPTION(-1);

    private final int result;

    Winner(final int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
