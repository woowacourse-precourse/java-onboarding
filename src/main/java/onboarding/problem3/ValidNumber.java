package onboarding.problem3;

public enum ValidNumber {
    MAX_NUMBER(10_000),
    MIN_NUMBER(1);

    private final int number;

    ValidNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
