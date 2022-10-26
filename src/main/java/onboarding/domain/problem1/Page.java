package onboarding.domain.problem1;

import java.util.ArrayList;
import java.util.List;

public class Page {

    private List<Integer> digitValues = new ArrayList<>();
    public Page(int pageNumber) {
        if (isOutOfRange(pageNumber))
            throw new IllegalArgumentException("페이지 범위는 3페이지부터 397페이지까지 입니다.");
        addNumbers(pageNumber);
    }

    private boolean isOutOfRange(int pageNumber) {
        return (pageNumber >398 && pageNumber < 3);
    }

    private void addNumbers(int pageNumber) {
        while (pageNumber > 0) {
            digitValues.add(pageNumber %10);
            pageNumber /= 10;
        }
    }

    public int getLargeValue() {
        int addSum = add(digitValues);
        int multiplySum = multiply(digitValues);
        if (addSum > multiplySum)
            return addSum;
        else
            return multiplySum;
    }

    private int multiply(List<Integer> digitValues) {
        int sum = 1;
        for (int val : digitValues) {
            sum *= val;
        }
        return sum;
    }

    private int add(List<Integer> digitValues) {
        int sum = 0;
        for (int val : digitValues) {
            sum += val;
        }
        return sum;
    }
}
