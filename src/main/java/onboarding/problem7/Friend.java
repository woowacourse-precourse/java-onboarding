package onboarding.problem7;

public enum Friend {
    FIRST_FRIEND(0),
    SECOND_FRIEND(1);

    private final int idx;

    Friend(int idx) {
        this.idx = idx;
    }

    public int value() {
        return this.idx;
    }
}
