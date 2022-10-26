package onboarding;

import java.util.Arrays;
import java.util.IllformedLocaleException;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        try {
            checkPagesSize(pobi, crong);
            checkPageValid(pobi, crong);
        } catch (Exception e) {
            return -1;
        }

        return compareScore(pobi, crong);
    }

    public static int calculatorMultiply(int page) {
        int result = 1;
        String[] splitPage = Integer.toString(page).split("");

        for (String eachPage : splitPage) {
            result *= Integer.parseInt(eachPage);
        }

        return result;
    }

    public static int calculatorAdd(int page) {
        int result = 0;
        String[] splitPage = Integer.toString(page).split("");

        for (String eachPage : splitPage) {
            result += Integer.parseInt(eachPage);
        }

        return result;
    }

    public static int compareMultiplyAndAdd(int pages) {
        int addResult = calculatorAdd(pages);
        int multiplyResult = calculatorMultiply(pages);

        return Math.max(addResult, multiplyResult);
    }

    public static int compareScore(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = Math.max(compareMultiplyAndAdd(pobi.get(0)), compareMultiplyAndAdd(pobi.get(1)));
        int crongScore = Math.max(compareMultiplyAndAdd(crong.get(0)), compareMultiplyAndAdd(crong.get(1)));

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    public static void checkPagesSize(List<Integer> pobi, List<Integer> crong) throws IllegalArgumentException {
        if (pobi.size() != 2 || crong.size() != 2)
            throw new IllegalArgumentException("Page의 개수가 2보다 많습니다!!");
    }

    public static void checkPageValid(List<Integer> pobi, List<Integer> crong) throws IllegalArgumentException {
        if (Math.abs(pobi.get(0) - pobi.get(1)) != 1 || Math.abs(crong.get(0) - crong.get(1)) != 1)
            throw new IllegalArgumentException("잘못된 페이지가 들어왔습니다. 각 페이지는 차가 1입니다.");
    }
}