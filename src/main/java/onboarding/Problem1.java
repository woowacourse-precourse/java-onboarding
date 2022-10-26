package onboarding;

import java.util.List;

class Problem1 {
    public static final int DRAW = 0;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int EXCEPTIONS_OCCURED = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        try {
            Pages pobiPages = Pages.of(pobi);
            Pages crongPages = Pages.of(crong);
        } catch (IllegalArgumentException e) {
            return EXCEPTIONS_OCCURED;
        }

        return answer;
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
    }
}