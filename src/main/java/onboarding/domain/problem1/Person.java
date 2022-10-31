package onboarding.domain.problem1;

import java.util.List;

public class Person {
    private Page pageOdd;
    private Page pageEven;

    public Person(List<Integer> pages) throws IllegalArgumentException {
        if (notHasTwoPage(pages))
            throw new IllegalArgumentException("두 페이지를 입력해야 합니다.");
        if (isNotContinuous(pages))
            throw new IllegalArgumentException("두 페이지는 연속된 값이어야 합니다.");
        if (isFirstDigitEven(pages))
            throw new IllegalArgumentException("첫 번째 페이지는 홀수여야 합니다.");
        pageOdd = new Page(pages.get(0));
        pageEven = new Page(pages.get(1));
    }

    private boolean notHasTwoPage(List<Integer> pages) {
        return pages.size() != 2;
    }

    private boolean isFirstDigitEven(List<Integer> pages) {
        return (pages.get(0)%2 == 0);
    }

    private boolean isNotContinuous(List<Integer> pages) {
        return (pages.get(1)-pages.get(0) != 1);
    }

    public int getLargeValue() {
        if (pageOdd.getLargeValue() > pageEven.getLargeValue())
            return pageOdd.getLargeValue();
        return pageEven.getLargeValue();
    }
}
