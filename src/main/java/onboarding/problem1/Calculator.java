package onboarding.problem1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calculator {
    public static int getMaxValue(List<Integer> allPossibleValues) {
        int biggest = Collections.max(allPossibleValues);
        return biggest;
    }
    public static List<Integer> getPossibleValues(Page page) {
        List<Integer> possibleValues = Arrays.asList(
                getSum(page.getLeftPage()), getSum(page.getRightPage()),
                getMult(page.getLeftPage()), getMult(page.getRightPage()));
        return possibleValues;
    }
    public static int getSum(int number) {
        int result = 0;
        while (number != 0) {
            result += (number % 10);
            number /= 10;
        }
        return result;
    }

    public static int getMult(int number) {
        int result = 1;
        while (number != 0) {
            result *= (number % 10);
            number /= 10;
        }
        return result;
    }
}
