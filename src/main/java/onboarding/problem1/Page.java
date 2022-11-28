package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class Page {

    private static final int MAX_PAGE = 400;
    private static final int MIN_PAGE = 1;

    private final int left;
    private final int right;

    public Page(List<Integer> page) {
        validatePage(page);
        left = page.get(0);
        right = page.get(1);
    }

    private void validatePage(List<Integer> page) {
        Integer left = page.get(0);
        Integer right = page.get(1);

        if (!validatePage(left, right)) {
            throw new IllegalArgumentException("Page 생성에 실패했습니다.");
        }
    }

    private boolean validatePage(Integer left, Integer right) {
        return (left >= MIN_PAGE && right <= MAX_PAGE)
            && (left % 2 == 1 && right == left + 1);
    }

    public int getMaxPageValue() {
        return Math.max(getMaxValue(left), getMaxValue(right));
    }

    private int getMaxValue(int page) {
        List<Integer> numberList = new ArrayList<>();

        while (page > 0) {
            numberList.add(page % 10);
            page = page / 10;
        }

        Integer sumValue = numberList.stream().reduce(0, Integer::sum);
        Integer multipleValue = numberList.stream().reduce(1, (sum, value) -> sum * value);

        return Math.max(sumValue, multipleValue);
    }
}
