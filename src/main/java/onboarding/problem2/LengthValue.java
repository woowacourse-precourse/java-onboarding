package onboarding.problem2;

public enum LengthValue {

    MIN(1),
    MAX(1000);

    private final int value;

    LengthValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
