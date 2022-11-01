package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Book selectedByPobi = new Book(pobi);
        Book selectedByCrong = new Book(crong);
        if (selectedByPobi.isInvalidPage() || selectedByCrong.isInvalidPage()) {
            return -1;
        }
        int pobiScore = ScoreCalculator.getScore(selectedByPobi);
        int crongScore = ScoreCalculator.getScore(selectedByCrong);
        return getWinner(pobiScore, crongScore);
    }

    private static int getWinner(Integer pobiScore, Integer crongScore) {
        int answer;
        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else {
            answer = 0;
        }
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

    static class ScoreCalculator {
        private ScoreCalculator() {
        }

        private static int getScore(Book book) {
            Integer leftPage = book.getPages().get(0);
            Integer rightPage = book.getPages().get(1);

            List<Integer> leftNumbers = getNumberList(leftPage);
            List<Integer> rightNumbers = getNumberList(rightPage);

            int leftScore = Math.max(sumNumbers(leftNumbers), mulNumbers(leftNumbers));
            int rightScore = Math.max(sumNumbers(rightNumbers), mulNumbers(rightNumbers));
            return Math.max(leftScore, rightScore);
        }

        private static List<Integer> getNumberList(Integer number) {
            List<Integer> numbers = new ArrayList<>();
            Integer mod = 1;
            while ((number / mod) != 0) {
                numbers.add((number / mod) % 10);
                mod *= 10;
            }
            return numbers;
        }

        private static Integer sumNumbers(List<Integer> numbers) {
            return numbers.stream()
                    .reduce(0, Integer::sum);
        }

        private static Integer mulNumbers(List<Integer> numbers) {
            return numbers.stream()
                    .reduce(1, (a, b) -> a * b);
        }
    }
}