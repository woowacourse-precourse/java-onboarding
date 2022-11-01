package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {

    private static int calculate(int num) {
        int resultSum = 0;
        int resultMulti = 1;

        while (num != 0) {
            resultSum += num % 10;
            resultMulti *= num % 10;
            num /= 10;
        }

        return max(resultSum, resultMulti);
    }

    private static boolean isContinuous(List<Integer> character) {
        if (character.get(1) - character.get(0) != 1) {
            return false;
        }
        return true;
    }

    private static int getResult(int answerPobi, int answerCrong) {
        if (answerPobi > answerCrong) {
            return 1;
        }
        else if (answerPobi < answerCrong) {
            return 2;
        }
        else {
            return 0;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int answerPobi = 0;
        int answerCrong = 0;

        if (!(isContinuous(pobi) && isContinuous(crong))) {
            return -1;
        }

        answerPobi = max(calculate(pobi.get(0)), calculate(pobi.get(1)));
        answerCrong = max(calculate(crong.get(0)), calculate(crong.get(1)));
        answer = getResult(answerPobi, answerCrong);

        return answer;
    }
}