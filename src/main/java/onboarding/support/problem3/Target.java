package onboarding.support.problem3;

public enum Target {
    THREE(3),
    SIX(6),
    NINE(9);

    private final int value;

    Target(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
