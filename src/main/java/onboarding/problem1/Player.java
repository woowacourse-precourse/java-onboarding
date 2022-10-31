package onboarding.problem1;

import java.util.List;

public class Player {
    public static final String LEFT_PAGE_IS_MORE_THAN_ONE = "[ERROR] 왼쪽페이지는 오른쪽페이지보다 1작아야합니다.";
    public static final String INPUT_LIST_SIZE_IS_TWO     = "[ERROR] 입력받은 리스트의 크기는 2개만 가능합니다.";

    private Page leftPage;
    private Page rightPage;

    public Player(List<Integer> numbers) {
        validateListSizeIsTwo(numbers);
        validateSecondNumberISMoreThanOne(numbers);

        this.leftPage  = new LeftPage(numbers.get(0));
        this.rightPage = new RightPage(numbers.get(1));
    }

    public Integer number() {
        return Math.max(leftPage.number(), rightPage.number());
    }

    // 2번째 값이 1번째보다 1커야만 합니다.
    private void validateSecondNumberISMoreThanOne(List<Integer> numbers) {
        if (numbers.get(1) - numbers.get(0) != 1) {
            throw new IllegalArgumentException(LEFT_PAGE_IS_MORE_THAN_ONE);
        }
    }

    private void validateListSizeIsTwo(List<Integer> numbers) {
        if (numbers.size() != 2) {
            throw new IllegalArgumentException(INPUT_LIST_SIZE_IS_TWO);
        }
    }
}
