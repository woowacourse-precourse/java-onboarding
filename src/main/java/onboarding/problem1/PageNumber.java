package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class PageNumber {
    public static String PAGE_NUMBER_IS_LESS_THAN_MIN_NUMBER = "[ERROR] 페이지 번호가 1이거나 1보다 작은 값입니다.";
    public static String PAGE_NUMBER_MORE_THAN_MAX_NUMBER    = "[ERROR] 페이지 번호가 400번이거나 400보다 큰 값입니다.";

    // 책 페이지는 1 그리고 그보다 작은 수를 가질 수 없습니다.
    private static final Integer MIN_NUMBER = 1;
    // 책 페이지는 400 그리고 그보다 큰 수를 가질 수 없습니다.
    private static final Integer MAX_NUMBER = 400;

    private Integer sum;
    private Integer multiple;

    public PageNumber(final Integer number) {
        validatePageNumberIsLessThanOrEqal(number);
        validatePageNumberIsMoreThanOrEqual(number);

        var numbers = this.stringToIntegerNumber(String.valueOf(number));
        this.calculateSum(numbers);
        this.calculateMultiple(numbers);
    }

    public Integer sum() {
        return this.sum;
    }

    public Integer multiple() {
        return this.multiple;
    }

    private List<Integer> stringToIntegerNumber(final String input) {
        List<Integer> numbers = new ArrayList<>();
        for (Character c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    private void calculateMultiple(List<Integer> numbers) {
        this.multiple = numbers.stream()
                               .reduce(1, (pre, cal) -> pre * cal);
    }

    private void calculateSum(List<Integer> numbers) {
        this.sum = numbers.stream()
                          .reduce(0, Integer::sum);
    }

    private void validatePageNumberIsMoreThanOrEqual(Integer number) {
        if (number >= MAX_NUMBER) {
            throw new IllegalArgumentException(PAGE_NUMBER_MORE_THAN_MAX_NUMBER);
        }
    }

    private void validatePageNumberIsLessThanOrEqal(Integer number) {
        if (number <= MIN_NUMBER) {
            throw new IllegalArgumentException(PAGE_NUMBER_IS_LESS_THAN_MIN_NUMBER);
        }
    }
}
