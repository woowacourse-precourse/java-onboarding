package onboarding;

import java.util.List;

class Problem1 {

    private final static int ERROR = -1;
    private final static int DRAW = 0;
    private final static int POBI_WIN = 1;
    private final static int CRONG_WIN = 2;
    private final static int MAX_PAGE = 398;
    private final static int MIN_PAGE = 2;
    private final static int EXPANDED_PAGE = 2;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        int pobiScore;
        int crongScore;

        if (exception(pobi) || exception(crong)) {
            return ERROR;
        }

        pobiScore = getMaxScore(pobi);
        crongScore = getMaxScore(crong);
        answer = GameResult(pobiScore, crongScore);

        return answer;
    }

    private static boolean exception(List<Integer> page) {
        int leftPage = page.get(0);
        int rightPage = page.get(1);

        if (page.size() != EXPANDED_PAGE) {
            return true;
        }
        if (leftPage != rightPage - 1) {
            return true;
        }
        if (leftPage < MIN_PAGE) {
            return true;
        }
        if (rightPage > MAX_PAGE) {
            return true;
        }
        return false;
    }

    private static int getMaxScore(List<Integer> user) {
        int score = 0;

        for (int i = 0; i < EXPANDED_PAGE; i++) {
            score = Math.max(score, maxScore(user.get(i)));
        }
        return score;
    }

    private static int maxScore(int num) {
        int page_sum = 0;
        int page_mult = 1;
        int max;

        while (num > 0) {
            page_sum += num % 10;
            page_mult *= num % 10;
            num /= 10;
        }
        max = Math.max(page_sum, page_mult);
        return max;
    }

    static int GameResult(int pobi_score, int crong_score) {
        int result = DRAW;

        if (pobi_score > crong_score) {
            result = POBI_WIN;
        } else if (crong_score > pobi_score) {
            result = CRONG_WIN;
        }
        return result;
    }
}

