package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class Page {

    private List<Integer> digitValues = new ArrayList<>();
    public Page(int pageNumber) {
        addNumbers(pageNumber);
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
