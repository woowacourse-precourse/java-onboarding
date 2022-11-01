package onboarding.problem1.type;

public enum ResultValue {

    POBI_WIN(1),
    CRONG_WIN(2),
    POBI_CRONG_DRAW(0),
    EXCEPTION_VALUE(-1);

    private final Integer value;

    ResultValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
