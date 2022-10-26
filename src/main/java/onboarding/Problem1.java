package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean isError(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        return (right <= left)
                || (left % 2 == 0)
                || (right % 2 == 1)
                || (right - left > 1)
                || (left <= 1)
                || (right >= 400);
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
            return Constants.DRAW;
        } else if (pobiScore > crongScore) {
            return Constants.WIN_POBI;
        } else {
            return Constants.WIN_CRONG;
        }
    }
}