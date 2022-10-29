package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore;
        int crongScore;

        if (!validateBoundary(pobi) || !validateBoundary(crong)) {
            return -1;
        }
        if (!validateInputFormat(pobi) || !validateInputFormat(crong)) {
            return -1;
        }
        if (!validateContinuous(pobi) || !validateContinuous(crong)) {
            return -1;
        }

        pobiScore = Math.max(compareMaxNum(pobi.get(0)), compareMaxNum(pobi.get(1)));
        crongScore = Math.max(compareMaxNum(crong.get(0)), compareMaxNum(crong.get(1)));

        answer = getResult(pobiScore, crongScore);
        return answer;
    }

    private static boolean validateInputFormat(List<Integer> numList) {
        Integer leftNum = numList.get(0);
        Integer rightNum = numList.get(1);
        return (leftNum % 2) == 1 && (rightNum % 2) == 0;
    }

    private static boolean validateContinuous(List<Integer> numList) {
        Integer leftNum = numList.get(0);
        Integer rightNum = numList.get(1);
        return (rightNum - leftNum) == 1;
    }

    private static boolean validateBoundary(List<Integer> numList) {
        Integer leftNum = numList.get(0);
        Integer rightNum = numList.get(1);
        return leftNum >= 1 && leftNum <= 400 && rightNum >= 1 && rightNum <= 400;
    }

    private static int addDigit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    private static int multiplyDigit(int num) {
        int temp = 1;
        while (num != 0) {
            temp *= (num % 10);
            num /= 10;
        }
        return temp;
    }

    private static int compareMaxNum(int num) {
        return Math.max(addDigit(num), multiplyDigit(num));
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