package onboarding.problem1;

public class LeftPage extends Page {
    public static String LEFT_PAGE_NUMBER_IS_NOT_EVEN = "[ERROR] 왼쪽 페이지 숫자는 홀수이여만 합니다.";

    public LeftPage(final Integer input) {
        super(input);
        this.validateNumberIsEven(input);
    }

    private void validateNumberIsEven(Integer input) {
        if (input % 2 == 0) {
            throw new IllegalArgumentException(LEFT_PAGE_NUMBER_IS_NOT_EVEN);
        }
    }
}
