package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            checkException(pobi);
            checkException(crong);

            int pobiScore = calMaxScore(pobi);
            int crongScore = calMaxScore(crong);

            return findWinner(pobiScore, crongScore);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static void checkException(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // 페이지 범위 예외 확인
        if (leftPage < 1 || leftPage > 400 || rightPage < 1 || rightPage > 400) {
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
