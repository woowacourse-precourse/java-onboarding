package onboarding;

import java.util.List;

class Problem1 {

    private static boolean isCorrectPage(List<Integer> player) {
        int leftPage = player.get(0);
        int rightPage = player.get(1);

        if (leftPage - rightPage != -1) {
            return false;
        }

        if (leftPage % 2 == 0 || rightPage % 2 != 0) {
            return false;
        }

        if (leftPage < 1 || rightPage > 400) {
            return false;
        }

        return true;
    }

    private static boolean isFirstOrLastPage(List<Integer> player) {
        for (int pageNum : player) {
            if (pageNum == 1 || pageNum == 400) {
                return true;
            }
        }
        return false;
    }

    private static int calculateMaxScore(List<Integer> person) {
        int leftNum = calculateScore(person.get(0));
        int rightNum = calculateScore(person.get(1));
        return Math.max(leftNum, rightNum);
    }

    private static int calculateScore(int num) {
        int summedNum = calculateBySumRule(num);
        int multipliedNum = calculateByMultiplyRule(num);
        return Math.max(summedNum, multipliedNum);
    }

    private static int calculateBySumRule(int num) {
        String stringInt = String.valueOf(num);
        int sum = 0;
        for (int i=0; i< stringInt.length(); i++) {
            String convertedNum = String.valueOf(stringInt.charAt(i));
            sum += Integer.parseInt(convertedNum);
        }
        return sum;
    }

    private static int calculateByMultiplyRule(int num) {
        String stringInt = String.valueOf(num);
        int multiply = 1;
        for (int i=0; i< stringInt.length(); i++) {
            String convertedNum = String.valueOf(stringInt.charAt(i));
            multiply *= Integer.parseInt(convertedNum);
        }
        return multiply;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isCorrectPage(pobi) || !isCorrectPage(crong) || isFirstOrLastPage(pobi) || isFirstOrLastPage(crong)  ) {
            return -1;
        }

        int pobiScore = calculateMaxScore(pobi);
        int crongScore = calculateMaxScore(crong);

        int result;

        if (pobiScore > crongScore) {
            result = 1;
        } else if (pobiScore == crongScore) {
            result = 0;
        } else {
            result = 2;
        }

        return result;
    }
}