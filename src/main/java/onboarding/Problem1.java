package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalid(pobi) || isInvalid(crong)) return -1;

        int pobiScore = calcScore(pobi);
        int crongScore = calcScore(crong);

        if (pobiScore > crongScore) return 1;
        else if (pobiScore < crongScore) return 2;
        else return 0;
    }

    private static boolean isInvalid(List<Integer> pages) {
        try {
            int leftPage = pages.get(0);
            int rightPage = pages.get(1);
            return !(leftPage < 400 && leftPage % 2 == 1 && rightPage == leftPage + 1);
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    }

    private static int digitSum(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    private static int digitMul(int num) {
        int result = 1;
        while (num > 0) {
            result *= num % 10;
            num /= 10;
        }
        return result;
    }

    private static int calcScore(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        int leftScore = Math.max(digitSum(leftPage), digitMul(leftPage));
        int rightScore = Math.max(digitSum(rightPage), digitMul(rightPage));
        return Math.max(leftScore, rightScore);
    }
}