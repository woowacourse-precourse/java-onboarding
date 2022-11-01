package onboarding;

import java.util.List;

class Problem1 {

    private static int sumOfDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static int multiplyOfDigit(int num) {
        int multiply = 1;
        while (num > 0) {
            multiply *= num % 10;
            num /= 10;
        }
        return multiply;
    }

    private static int getMaxScore(List<Integer> pages) {
        int maxScore = 0;
        for (int page : pages) {

            if (sumOfDigit(page) == 0 || multiplyOfDigit(page) == 0) {
                throw new Error("점수가 유효하지 않습니다.");
            }

            int newScore = Math.max(sumOfDigit(page), multiplyOfDigit(page));
            maxScore = Math.max(newScore, maxScore);
        }

        return maxScore;
    }

    private static int getPageNumberGameResult(int pobiScore, int crongScore) {

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        try {

            int pobiMaxScore = getMaxScore(pobi);
            int crongMaxScore = getMaxScore(crong);

            return getPageNumberGameResult(pobiMaxScore, crongMaxScore);

        } catch (Error e) {
            return -1;
        }
    }
}