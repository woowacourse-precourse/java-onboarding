package onboarding.problem1;

public class RightPage extends Page {
    public static final String RIGHT_PAGE_NUMBER_IS_NOT_EVEN = "[ERROR] 오른쪽 페이지 숫자는 홀수이여만 합니다.";

    public RightPage(final Integer number) {
        super(number);
        this.validateNumberIsOdd(number);
    }

    private void validateNumberIsOdd(Integer input) {
        if (input % 2 != 0) {
            throw new IllegalArgumentException(RIGHT_PAGE_NUMBER_IS_NOT_EVEN);
        }
    }
}
