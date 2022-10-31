package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int WIN_POBI = 1;
    private static final int WIN_CRONG = 2;
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    private static final int END_PAGE = 400;
    private static final int START_PAGE = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = 0;
        int crongScore = 0;

        if (!canExecute(pobi) || !canExecute(crong))
            return EXCEPTION;

        pobiScore = calculateMaxScore(pobi);
        crongScore = calculateMaxScore(crong);

        answer = makeGameResult(pobiScore, crongScore);

        return answer;
    }

    private static boolean canExecute(List<Integer> list) {
        int left = list.get(LEFT_PAGE);
        int right = list.get(RIGHT_PAGE);

        return (right == left + 1)
                && (left % 2 == 1)
                && (right % 2 == 0)
                && (right <= END_PAGE)
                && (left >= START_PAGE);
    }

    private static int sum(int n) {
        if (n < 10)
            return n;
        return n % 10 + sum(n / 10);
    }

    private static int multiply(int n) {
        if (n < 10)
            return n;
        return n % 10 * multiply(n / 10);
    }

    private static int calculateMaxScore(List<Integer> pageList) {
        int maxScore = 0;

        for (Integer page : pageList) {
            int pageToInt = page.intValue();
            maxScore = Math.max(sum(pageToInt), maxScore);
            maxScore = Math.max(multiply(pageToInt), maxScore);
        }
        return maxScore;
    }

    private static int makeGameResult(int pobiScore, int crongScore) {
        if (pobiScore == crongScore) {
            return DRAW;
        } else if (pobiScore > crongScore) {
            return WIN_POBI;
        } else {
            return WIN_CRONG;
        }
    }
}