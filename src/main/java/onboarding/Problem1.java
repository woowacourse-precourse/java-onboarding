package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore, crongScore, answer;

        if (!ValidationFor1.isValidateInput(pobi) || !ValidationFor1.isValidateInput(crong)) {
            return -1;
        }

        pobiScore = ScoreController.calcScore(pobi);
        crongScore = ScoreController.calcScore(crong);
        answer = ScoreController.compareScore(pobiScore, crongScore);
        return answer;
    }
}


class ValidationFor1 {
    static final int MAX_PAGE = 400;
    static final int MIN_PAGE = 1;

    static boolean isValidateInput(List<Integer> input) {

        return !(input.get(1) - input.get(0) != 1
                || input.get(1) >= MAX_PAGE
                || input.get(0) <= MIN_PAGE);
    }
}


class ScoreController {
    private static int sumDigits(int num) {
        int result = 0;

        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    private static int mulDigits(int num) {
        int result = 1;

        while (num!=0) {
            result *= num % 10;
            num /= 10;
        }
        return result;
    }

    static int calcScore(List<Integer> pageList) {
        int result;
        int leftMax = Math.max(sumDigits(pageList.get(0)), mulDigits(pageList.get(0)));
        int rightMax = Math.max(sumDigits(pageList.get(1)), mulDigits(pageList.get(1)));

        result = Math.max(leftMax,rightMax);
        return result;
    }

    static int compareScore(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }
}
