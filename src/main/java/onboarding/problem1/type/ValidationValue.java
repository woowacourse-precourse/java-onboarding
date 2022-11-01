package onboarding.problem1.type;

public enum ValidationValue {

    LEFT_INDEX(0),
    RIGHT_INDEX(1);

    private final Integer value;

    ValidationValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
