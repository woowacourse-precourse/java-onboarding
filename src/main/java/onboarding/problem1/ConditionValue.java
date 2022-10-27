package onboarding.problem1;

public enum ConditionValue {

    FIXED_LIST_SIZE(2),
    LEFT_INDEX(0),
    RIGHT_INDEX(1),
    POBI_WIN(1),
    CRONG_WIN(2),
    POBI_CRONG_DRAW(0),
    EXCEPTION_VALUE(-1);

    private final Integer value;

    ConditionValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
