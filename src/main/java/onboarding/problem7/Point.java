package onboarding.problem7;

public enum Point {
    DEFAULT(0),
    VISITOR(1),
    FRIEND_CANDIDATE(10);


    Point(int value) {
        this.value = value;
    }

    private final int value;

    public int getValue() {
        return value;
    }
}
