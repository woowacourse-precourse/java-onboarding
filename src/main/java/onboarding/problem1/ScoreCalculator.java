package onboarding.problem1;


import java.util.List;

public class ScoreCalculator {

    public static int calculate(List<Integer> pages) {
        return Math.max(calcMaxAtPage(pages.get(0)), calcMaxAtPage(pages.get(1)));
    }

    private static int calcMaxAtPage(Integer page) {
        int plusResult = 0;
        int multiResult = 1;
        int tmp = page;
        while (tmp >= 1) {
            int lastDigit = tmp % 10;
            plusResult += lastDigit;
            multiResult *= lastDigit;
            tmp /= 10;
        }
        return Math.max(plusResult, multiResult);
    }
}
