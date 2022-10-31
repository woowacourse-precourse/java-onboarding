package onboarding;

import java.util.List;

import static java.lang.Math.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) { /// [399, 400]
        int answer = Integer.MAX_VALUE;

        if (checkException(pobi.get(0), pobi.get(1)) && checkException(crong.get(0), crong.get(1))) {
            answer = 1;
        }
        else {
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

    private static int mulPage(int number) {
        int score = 1;
        while (number != 0) {
            score *= number % 10;
            number /= 10;
        }
        return score;
    }

    private static int addPage(int number) {
        int score = 0;
        while (number != 0) {
            score += number % 10;
            number /= 10;
        }
        return score;
    }
}