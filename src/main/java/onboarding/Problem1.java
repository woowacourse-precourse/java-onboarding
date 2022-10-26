package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            validatePages(pobi);
            validatePages(crong);
        } catch (IllegalArgumentException e) {
            return -1;
        }

        int pobiScore = scoreFrom(pobi);
        int crongScore = scoreFrom(crong);
        if (pobiScore == crongScore) {
            return 0;
        }
        if (pobiScore > crongScore) {
            return 1;
        }
        return 2;
    }

    private static void validatePages(List<Integer> pages) {
        if (pages.size() != 2) {
            throw new IllegalArgumentException("책 페이지는 두 쪽이 입력되어야 합니다.");
        }

        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (leftPage < 1 || leftPage > 400 || leftPage % 2 == 0 || rightPage < 1 || rightPage > 400 || rightPage % 2 == 1) {
            throw new IllegalArgumentException("올바른 페이지 번호가 아닙니다.");
        }
        if (rightPage - leftPage != 1) {
            throw new IllegalArgumentException("연속된 페이지 번호를 입력해주세요.");
        }
    }

    private static int scoreFrom(List<Integer> pages) {
        return pages.stream()
                .map(Problem1::findMaxScore)
                .max(Integer::compareTo).orElse(-1);
    }

    private static int findMaxScore(Integer page) {
        Integer[] digits = pageToDigitNumbers(page);
        return Math.max(addNumbers(digits), multiplyNumbers(digits));
    }

    private static Integer[] pageToDigitNumbers(Integer page) {
        int digit = String.valueOf(page).length();
        Integer[] digitNumbers = new Integer[digit];
        for (int i = 0; i < digit; i++) {
            digitNumbers[i] = page % 10;
            page /= 10;
        }
        return digitNumbers;
    }

    private static int multiplyNumbers(Integer[] digits) {
        return Arrays.stream(digits).reduce(1, (integer, integer2) -> integer * integer2);
    }

    private static int addNumbers(Integer[] digits) {
        return Arrays.stream(digits).reduce(0, Integer::sum);
    }
}
