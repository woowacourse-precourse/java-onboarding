package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!exceptionCheck(pobi, crong)) {
            answer = -1;
            return answer;
        }

        int pobiFinalScore = getFinalScore(pobi);
        int crongFinalScore = getFinalScore(crong);

        if (pobiFinalScore > crongFinalScore) {
            answer = 1;
        }

        if (pobiFinalScore < crongFinalScore) {
            answer = 2;
        }

        if (pobiFinalScore == crongFinalScore){
            answer = 0;
        }

        return answer;
    }

    private static boolean exceptionCheck(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) == null || pobi.get(1) == null ||
                crong.get(0) == null || crong.get(1) == null) {
            return false;
        }

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);

        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (pobiLeftPage >= pobiRightPage || crongLeftPage >= crongRightPage) {
            return false;
        }

        if (pobiRightPage - pobiLeftPage != 1 || crongRightPage - crongLeftPage != 1) {
            return false;
        }

        if (pobiLeftPage == 1 || pobiRightPage == 1 ||
                pobiLeftPage == 400 || pobiRightPage == 400 ||
                crongLeftPage == 1 || crongRightPage == 1 ||
                crongLeftPage == 400 || crongRightPage == 400) {
            return false;
        }

        if (pobiLeftPage <= 1 || pobiRightPage >= 400 ||
                crongLeftPage <= 1 || crongRightPage >= 400) {
            return false;
        }

        if (pobiLeftPage % 2 == 0 || pobiRightPage % 2 != 0 ||
                crongLeftPage % 2 == 0 || crongRightPage % 2 != 0) {
            return false;
        }

        return true;
    }

    private static int getFinalScore(List<Integer> player) {
        List<Integer> scoreList = new ArrayList<Integer>(Arrays.asList(0, 0));

        int maxNum = getMaxNum(player.get(0));
        scoreList.set(0, maxNum);

        maxNum = getMaxNum(player.get(1));
        scoreList.set(1, maxNum);

        int finalScore = Math.max(scoreList.get(0), scoreList.get(1));

        return finalScore;
    }

    private static int getMaxNum(int num) {
        int plus = plusAllDigit(num);
        int multiply = multiplyAllDigit(num);

        int ret = Math.max(plus, multiply);
        return ret;
    }

    private static int plusAllDigit(int num) {
        int sum = 0;

        while (num > 0) {
            sum += (num % 10);

            num = num / 10;
        }

        return sum;
    }

    private static int multiplyAllDigit(int num) {
        int multiplyResult = 1;

        while (num > 0) {
            multiplyResult *= (num % 10);

            num = num / 10;
        }

        return multiplyResult;
    }
}