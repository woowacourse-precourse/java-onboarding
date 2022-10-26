package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Problem1 {

    public static int solution(List<Integer> pobiPageNumbers, List<Integer> crongPageNumbers) {
        try {
            Player pobi = new Player(asPages(pobiPageNumbers));
            Player crong = new Player(asPages(crongPageNumbers));

            return pobi.battle(crong);
        } catch (RuntimeException e) {
            return -1;
        }
    }

    private static List<Page> asPages(List<Integer> pageNumbers) {
        List<Page> result = new ArrayList<>();
        for (Integer pageNumber : pageNumbers) {
            result.add(new Page(pageNumber));
        }
        return result;
    }

    private static class Player {

        private static final String ERR_PAGES_SIZE = "페이지는 2개만 입력하시오.";
        private static final String ERR_PAGES_ORDER = "좌우 페이지 순서대로 입력하시오.";
        private final List<Page> pages;

        public Player(List<Page> pages) {
            this.pages = Objects.requireNonNull(pages);
            validatePages();
        }

        private void validatePages() {
            validatePagesSize();
            validatePagesOrder();
        }

        private void validatePagesSize() {
            if (pages.size() != 2) throw new IllegalStateException(ERR_PAGES_SIZE);
        }

        private void validatePagesOrder() {
            Page firstPage = pages.get(0), secondPage = pages.get(1);
            if (!firstPage.isOdd() && firstPage.compareTo(secondPage) != -1)
                throw new IllegalArgumentException(ERR_PAGES_ORDER);
        }

        public int battle(Player other) {
            return 0;
        }
    }

    private static class Page implements Comparable<Page> {
        private static final int LOWER_BOUND = 1;
        private static final int UPPER_BOUND = 400;
        private static final String ERR_PAGE_BOUND = "페이지는 1 ~ 400까지의 값입니다.";
        private final int page;

        public Page(int page) {
            this.page = page;
            validatePageBound();
        }

        private void validatePageBound() {
            if (page < LOWER_BOUND || page > UPPER_BOUND)
                throw new IllegalArgumentException(ERR_PAGE_BOUND);
        }

        public int getScore() {
            return Math.max(sumDigits(), multiplyDigits());
        }

        private int sumDigits() {
            int result = 0, num = page;
            while (num > 0) {
                result += num % 10;
                num /= 10;
            }
            return result;
        }

        private int multiplyDigits() {
            int result = 0, num = page;
            while (num > 0) {
                result *= num % 10;
                num /= 10;
            }
            return result;
        }

        public boolean isOdd() {
            return page % 2 == 1;
        }

        @Override
        public int compareTo(Page other) {
            return this.page - other.page;
        }
    }
}