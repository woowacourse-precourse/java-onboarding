package onboarding.problem1;

public enum ConditionValue {

    // TODO 열거타입이 무엇을 위한 열거타입 인지? 결과를 반환하는 열거 타입인지? 페이지를 검증하는 열거 타입인지?
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
