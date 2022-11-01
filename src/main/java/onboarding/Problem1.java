package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static int FIRST_PAGE = 1;
    static int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePageList(pobi) || !validatePageList(crong)) {
            return -1;
        }
        int answer = numberGame(pobi, crong);
        return answer;
    }


    private static boolean validatePageList(List<Integer> pageList) {
        if (!isConsecutive(pageList)) {
            return false;
        }
        if (!isLeftPageOdd(pageList)) {
            return false;
        }
        if (!isInRange(pageList)) {
            return false;
        }
        if (isEdge(pageList)) {
            return false;
        }
        return true;
    }

    private static boolean isConsecutive(List<Integer> pageList) {
        return pageList.get(0) + 1 == pageList.get(1);
    }

    private static boolean isLeftPageOdd(List<Integer> pageList) {
        return pageList.get(0) % 2 == 1;
    }

    private static boolean isInRange(List<Integer> pageList) {
        if (pageList.get(0) < FIRST_PAGE) {
            return false;
        }
        if (pageList.get(1) > LAST_PAGE) {
            return false;
        }
        return true;
    }

    private static boolean isEdge(List<Integer> pageList) {
        if (pageList.get(0) == FIRST_PAGE) {
            return true;
        }
        if (pageList.get(1) == LAST_PAGE) {
            return true;
        }
        return false;
    }


    private static int numberGame(List<Integer> leftPlayer, List<Integer> rightPlayer) {
        int LEFT_WIN = 1;
        int RIGHT_WIN = 2;
        if (getScore(leftPlayer) < getScore(rightPlayer)) {
            return RIGHT_WIN;
        }
        if (getScore(leftPlayer) > getScore(rightPlayer)) {
            return LEFT_WIN;
        }
        return 0;
    }

    private static int getScore(List<Integer> pageList) {
        List<Integer> leftPageDigits = getDigits(pageList.get(0));
        List<Integer> rightPageDigits = getDigits(pageList.get(1));
        int maxSum = Math.max(getSum(leftPageDigits), getSum(rightPageDigits));
        int maxMul = Math.max(getMul(leftPageDigits), getMul(rightPageDigits));
        return Math.max(maxSum, maxMul);
    }

    private static List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }

    private static int getSum(List<Integer> digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    private static int getMul(List<Integer> digits) {
        int mul = 0;
        for (int digit : digits) {
            mul *= digit;
        }
        return mul;
    }
}