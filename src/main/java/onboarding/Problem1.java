package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore;
        int crongScore;

        if (checkException(pobi) || checkException(crong)) {
            return -1;
        }

        pobiScore = Math.max(compareMaxNum(pobi.get(0)), compareMaxNum(pobi.get(1)));
        crongScore = Math.max(compareMaxNum(crong.get(0)), compareMaxNum(crong.get(1)));

        return getResult(pobiScore, crongScore);
    }

    private static boolean checkException(List<Integer> numList) {
        int leftNum = numList.get(0);
        int rightNum = numList.get(1);
        return !validateBoundary(leftNum, rightNum) || !validateInputFormat(leftNum, rightNum) || !validateContinuous(leftNum, rightNum);
    }
    private static boolean validateInputFormat(int leftNum, int rightNum) {
        return (leftNum % 2) == 1 && (rightNum % 2) == 0;
    }

    private static boolean validateContinuous(int leftNum, int rightNum) {
        return (rightNum - leftNum) == 1;
    }

    private static boolean validateBoundary(int leftNum, int rightNum) {
        return leftNum >= 1 && leftNum <= 400 && rightNum >= 1 && rightNum <= 400;
    }

    private static int addAllDigit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    private static int multiplyAllDigit(int num) {
        int sum = 1;
        while (num != 0) {
            sum *= (num % 10);
            num /= 10;
        }
        return sum;
    }

    private static int compareMaxNum(int num) {
        return Math.max(addAllDigit(num), multiplyAllDigit(num));
    }

    private static int getResult(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

}