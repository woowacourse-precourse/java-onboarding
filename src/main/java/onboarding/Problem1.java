package onboarding;

import static java.lang.Integer.max;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

class Problem1 {

    final static int FIRST_PAGE = 1;
    final static int LAST_PAGE = 400;

    final static int LEFT_WIN = 1;
    final static int DRAW = 0;
    final static int RIGHT_WIN = 2;
    final static int EXCEPT_CASE = -1;

    public static int getResult(List<Integer> leftUser, List<Integer> rightUser) {
        int result = 0;
        try {
            int leftPoint = getUserMaxPoint(leftUser);
            int rightPoint = getUserMaxPoint(rightUser);

            if (leftPoint > rightPoint) {
                result = LEFT_WIN;
            } else if (leftPoint == rightPoint) {
                result = DRAW;
            } else {
                result = RIGHT_WIN;
            }
        } catch (InputMismatchException e) {
            result = EXCEPT_CASE;
        } finally {
            return result;
        }

    }

    public static int getUserMaxPoint(List<Integer> pages) {
        if (isInvalidPages(pages)) {
            throw new InputMismatchException("허용되지 않는 입력입니다.");
        }

        return max(getPageMaxPoint(pages.get(0)), getPageMaxPoint(pages.get(1)));
    }

    private static boolean isInvalidPages(List<Integer> pages) {
        return pages.size() == 2 && (pages.get(0) == FIRST_PAGE || pages.get(1) == LAST_PAGE
                || pages.get(0) + 1 != pages.get(1));
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
        return getResult(pobi, crong);
    }
}