package onboarding;

import java.util.List;

class Problem1 {
    public static final int DRAW = 0;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int EXCEPTIONS_OCCURED = -1;

    private static int pobiScore;
    private static int crongScore;

    private static Pages pobiPages;
    private static Pages crongPages;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            pobiPages = Pages.of(pobi);
            crongPages = Pages.of(crong);
        } catch (IllegalArgumentException e) {
            return EXCEPTIONS_OCCURED;
        }

        pobiScore = Pages.makeScore(pobiPages);
        crongScore = Pages.makeScore(crongPages);

        return findWinnerAndMakeAnswer(pobiScore, crongScore);
    }

    private static int findWinnerAndMakeAnswer(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }

        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }

        return DRAW;
    }

    static class Pages {
        private static final int SIZE_OF_PAGES = 2;
        private static final int FIRST_PAGE_NUMBER = 1;
        private static final int LAST_PAGE_NUMBER = 400;

        private final List<Integer> pages;

        private Pages(List<Integer> pages) {
            this.pages = pages;
        }

        public static Pages of(List<Integer> pages) {
            validate(pages);
            return new Pages(pages);
        }

        private static void validate(List<Integer> pages) {
            validateListSize(pages);
            validateContinuousPages(pages);
            validateFirstOrLastPages(pages);
        }

        private static void validateListSize(List<Integer> pages) {
            if (pages.size() != SIZE_OF_PAGES) {
                throw new IllegalArgumentException();
            }
        }

        private static void validateContinuousPages(List<Integer> pages) {
            if (pages.get(0) % 2 == 0 || pages.get(0) + 1 != pages.get(1)) {
                throw new IllegalArgumentException();
            }
        }

        private static void validateFirstOrLastPages(List<Integer> pages) {
            if (pages.get(0) == FIRST_PAGE_NUMBER || pages.get(1) == LAST_PAGE_NUMBER) {
                throw new IllegalArgumentException();
            }
        }

        private static int makeScore(Pages pages) {
            return Math.max(makeScoreByAddition(pages.pages), makeScoreByMultiplication(pages.pages));
        }

        private static int makeScoreByAddition(List<Integer> pages) {
            return Math.max(calculateScoreByAddition(pages.get(0)), calculateScoreByAddition(pages.get(1)));
        }

        private static int makeScoreByMultiplication(List<Integer> pages) {
            return Math.max(calculateScoreByMultiplication(pages.get(0)), calculateScoreByMultiplication(pages.get(1)));
        }

        private static int calculateScoreByAddition(int number) {
            int total = 0;

            while (number != 0) {
                total += (number % 10);
                number /= 10;
            }

            return total;
        }

        private static int calculateScoreByMultiplication(int number) {
            int total = 1;

            while (number != 0) {
                total *= (number % 10);
                number /= 10;
            }

            return total;
        }
    }
}