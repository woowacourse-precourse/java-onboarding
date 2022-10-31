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

        private boolean isPageEven(Integer page) {
            return (page % 2) == 0;
        }

        public List<Integer> getPages() {
            return pages;
        }
    }
}