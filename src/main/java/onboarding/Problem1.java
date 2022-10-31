package onboarding;

import java.util.List;


import static java.lang.Math.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) { /// [52, 53] , [160, 161]
        int answer = Integer.MAX_VALUE;

        if (checkException(pobi.get(0), pobi.get(1)) && checkException(crong.get(0), crong.get(1))) {
            answer = winner(pobi, crong);
        } else {
            answer = -1;
        }
        return answer;
    }

    public static boolean checkException(int leftPage, int rightPage) {
        if (leftPage > 400 || leftPage < 1 || rightPage > 400 || rightPage < 1 || (rightPage - leftPage != 1)) {
            return false;
        }
        return true;

    }

    public static int winner(List<Integer> pobi, List<Integer> crong) {
        int p = Math.max(mulPage(pobi.get(0)), addPage(pobi.get(1)));
        int c = Math.max(mulPage(crong.get(0)), addPage(crong.get(1)));

        if (p < c) {
            return 2;
        }
        else if (p > c) {
            return 1;
        }
        else        {
            return 0;
        }

    }

    private static int mulPage(int page) {
        int score = 1;
        while (page != 0) {
            score *= page % 10;
            page /= 10;
        }
        return score;
    }

    private static int addPage(int page) {
        int score = 0;
        while (page != 0) {
            score += page % 10;
            page /= 10;
        }
        return score;
    }
}
