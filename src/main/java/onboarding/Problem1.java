package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            checkException(pobi);
            checkException(crong);

            int pobiScore = calScore(pobi);
            int crongScore = calScore(crong);

            return findWinner(pobiScore, crongScore);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    private static int findWinner(int score1, int score2) {
        if (score1 > score2) {
            return 1;
        }
        if (score1 < score2) {
            return 2;
        }
        return 0;
    }

    private static int calScore(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        int leftPageScore = calPageScore(leftPage);
        int rightPageScore = calPageScore(rightPage);

        return Math.max(leftPageScore, rightPageScore);
    }

    private static int calPageScore(int page) {
        List<Integer> eachDigitNumbers = splitNumbers(page);

        int addScore = calAddScore(eachDigitNumbers);
        int multipleScore = calMultipleScore(eachDigitNumbers);

        return Math.max(addScore, multipleScore);
    }

    public static List<Integer> splitNumbers(int page) {
        List<Integer> seperatedNumbers = new ArrayList<>();
        while (page != 0) {
            seperatedNumbers.add(page % 10);
            page /= 10;
        }
        return seperatedNumbers;
    }

    private static int calAddScore(List<Integer> eachDigitNumbers) {
        int score = 0;
        for (Integer digitNumber : eachDigitNumbers) {
            score += digitNumber;
        }
        return score;
    }

    private static int calMultipleScore(List<Integer> eachDigitNumbers) {
        int score = 1;
        for (Integer digitNumber : eachDigitNumbers) {
            score *= digitNumber;
        }
        return score;
    }

    public static void checkException(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // 페이지 범위 예외 확인
        if (leftPage <= 1 || leftPage >= 400 || rightPage <= 1 || rightPage >= 400) {
            throw new RuntimeException("페이지 범위 예외");
        }

        // 왼쪽 페이지가 짝수인 경우
        if (leftPage % 2 == 0) {
            throw new RuntimeException("왼쪽 페이지는 홀수여야 한다.");
        }

        // 두 수가 연속이 아닌 경우
        if (rightPage != leftPage + 1) {
            throw new RuntimeException("두 수는 연속이어야 한다.");
        }
    }
}
