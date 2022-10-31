package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    static class Book {
        private final List<Integer> pages;

        public Book(List<Integer> pages) {
            this.pages = pages;
        }

        private boolean isInvalidPage() {
            if (pages.size() != 2) {
                return true;
            }

            Integer leftPage = pages.get(0);
            Integer rightPage = pages.get(1);

            if (isPageEven(leftPage) || isPageNotAdjacent(leftPage, rightPage) || isFirstPage() || isLastPage()) {
                return true;
            }
            return false;
        }
        private boolean isFirstPage() {
            return pages.get(0) <= 1;
        }

        private boolean isLastPage() {
            return pages.get(1) >= 400;
        }

        private boolean isPageEven(Integer page) {
            return (page % 2) == 0;
        }

        private boolean isPageNotAdjacent(Integer leftPage, Integer rightPage) {
            return (leftPage + 1 != rightPage);
        }

        public List<Integer> getPages() {
            return pages;
        }
    }
}