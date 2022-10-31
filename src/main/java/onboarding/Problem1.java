package onboarding;

import static java.lang.Integer.max;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

class Problem1 {

    static class Page {

        private final int FIRST_PAGE = 1;
        private final int LAST_PAGE = 400;

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


    static class User {

        private Page leftPage;
        private Page rightPage;

        public User(List<Integer> pages) {
            if (!isValidPages(pages)) {
                throw new InputMismatchException("허용되지 않는 입력입니다.");
            }

            this.leftPage = makePage(pages.get(0));
            this.rightPage = makePage(pages.get(1));
        }


        private boolean isValidPages(List<Integer> pages) {
            return pages.size() == 2 && pages.get(0) + 1 == pages.get(1);
        }

        public int maxPoint() {
            return max(leftPage.getPageMaxPoint(), rightPage.getPageMaxPoint());
        }

    }

    static User makeUser(List<Integer> pages) {
        return new User(pages);
    }

    static class Result {


        final private int LEFT_WIN = 1;
        final private int DRAW = 0;
        final private int RIGHT_WIN = 2;
        final private int EXCEPT_CASE = -1;

        private int value;

        Result(List<Integer> leftUserPages, List<Integer> rightUserPages) {

            try {
                int leftPoint = makeUser(leftUserPages).maxPoint();
                int rightPoint = makeUser(rightUserPages).maxPoint();

                if (leftPoint > rightPoint) {
                    value = LEFT_WIN;
                } else if (leftPoint == rightPoint) {
                    value = DRAW;
                } else {
                    value = RIGHT_WIN;
                }
            } catch (InputMismatchException e) {
                value = EXCEPT_CASE;
            }
        }

        public int getValue() {
            return this.value;
        }


    }

    private static Result makeResult(List<Integer> leftUserPages, List<Integer> rightUserPages) {
        return new Result(leftUserPages, rightUserPages);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return makeResult(pobi, crong).getValue();
    }
}