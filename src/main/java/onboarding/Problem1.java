package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!validateBoundary(pobi) || !validateBoundary(crong)) {
            return -1;
        }
        if (!validateInputFormat(pobi) || !validateInputFormat(crong)) {
            return -1;
        }
        if (!validateContinuous(pobi) || !validateContinuous(crong)) {
            return -1;
        }
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
}