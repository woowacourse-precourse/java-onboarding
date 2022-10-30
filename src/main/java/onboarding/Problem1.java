package onboarding;

import static java.lang.Integer.max;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

class Problem1 {


    final static int LEFT_WIN = 1;
    final static int DRAW = 0;
    final static int RIGHT_WIN = 2;
    final static int EXCEPT_CASE = -1;

    static class Page {

        final static int FIRST_PAGE = 1;
        final static int LAST_PAGE = 400;

        private int page;

        public Page(int page) {

            if (!isValidPage(page)) {
                throw new InputMismatchException("허용되지 않는 페이지입니다.");
            }
            this.page = page;
        }

        private boolean isValidPage(int page) {
            return page != FIRST_PAGE && page != LAST_PAGE;
        }

        public int getPageMaxPoint() {
            List<Integer> digits = getDigits();

            return max(getMaxSum(digits), getMaxMultiple(digits));
        }

        private int getMaxMultiple(List<Integer> digits) {
            int ret = 1;

            for (int digit : digits) {
                ret *= digit;
            }

            return ret;
        }

        private int getMaxSum(List<Integer> digits) {
            int ret = 0;
            for (int digit : digits) {
                ret += digit;
            }
            return ret;
        }

        private List<Integer> getDigits() {
            List<Integer> digits = new ArrayList<>();

            while (page > 0) {
                digits.add(page % 10);
                page /= 10;
            }

            return digits;
        }
    }

    public static Page makePage(int page) {
        return new Page(page);
    }

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

    private static boolean isValidPages(List<Integer> pages) {
        return pages.size() == 2 && pages.get(0) + 1 == pages.get(1);
    }

    public static int getUserMaxPoint(List<Integer> pages) {

        if (!isValidPages(pages)) {
            throw new InputMismatchException("허용되지 않는 입력입니다.");
        }
        return max(makePage(pages.get(0)).getPageMaxPoint(), makePage(pages.get(1)).getPageMaxPoint());
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return getResult(pobi, crong);
    }
}