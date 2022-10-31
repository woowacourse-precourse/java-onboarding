package onboarding;

import java.util.List;

class Problem1 {

    public static final int DRAW = 0;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int ERROR = -1;
    public static final int FIRST_PAGE = 1;
    public static final int LAST_PAGE = 399;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (isNotLeftAndRightPage(pobiLeftPage, pobiRightPage) ||
                isNotLeftAndRightPage(crongLeftPage, crongRightPage)) {
            return ERROR;
        }

        int pobiScore = Math.max(calculateScore(pobiLeftPage), calculateScore(pobiRightPage));
        int crongScore = Math.max(calculateScore(crongLeftPage), calculateScore(crongRightPage));

        int answer = findWinner(pobiScore, crongScore);

        return answer;
    }

    private static int findWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return POBI_WIN;
        } else if (pobiScore == crongScore) {
            return DRAW;
        }

        return CRONG_WIN;
    }

    private static int calculateScore(int page) {
        int sum = 0;
        int multiply = 1;

        while (page > 0) {
            int value = page % 10;

            sum += value;
            multiply *= value;

            page = page / 10;
        }

        return Math.max(sum, multiply);
    }

    private static boolean isNotLeftAndRightPage(int leftPage, int rightPage) {
        return rightPage - leftPage != 1;
    }
}