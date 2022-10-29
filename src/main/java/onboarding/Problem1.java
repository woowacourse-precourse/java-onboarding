package onboarding;

import static java.lang.Integer.max;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

class Problem1 {
    final static int FIRST_PAGE = 1;
    final static int LAST_PAGE = 400;
    public static int getUserMaxPoint(List<Integer> pages) {
        if (pages.get(0) == FIRST_PAGE || pages.get(1) == LAST_PAGE) {
            throw new InputMismatchException("허용되지 않는 입력입니다.");
        }

        return max(getPageMaxPoint(pages.get(0)), getPageMaxPoint(pages.get(1)));
    }

    public static int getPageMaxPoint(int page) {
        List<Integer> digits = getDigits(page);

        return max(getMaxSum(digits), getMaxMultiple(digits));
    }

    private static int getMaxMultiple(List<Integer> digits) {
        int ret = 1;

        for (int digit : digits) {
            ret *= digit;
        }

        return ret;
    }

    private static int getMaxSum(List<Integer> digits) {
        int ret = 0;
        for (int digit : digits) {
            ret += digit;
        }
        return ret;
    }

    private static List<Integer> getDigits(int page) {
        List<Integer> digits = new ArrayList<>();

        while (page > 0) {
            digits.add(page % 10);
            page /= 10;
        }

        return digits;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}