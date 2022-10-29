package onboarding;

import java.util.List;

class Problem1 {
    static final int FIRST_PAGE = 1;
    static final int LAST_PAGE = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validateNum(pobi) || !validateNum(crong)) {
            return -1;
        }

        return getResult(pobi, crong);
    }

    static int getResult(List<Integer> player1, List<Integer> player2) {
        int player1Score = getScore(player1);
        int player2Score = getScore(player2);

        return gameResult(player1Score, player2Score);
    }

    static int gameResult(int player1Score, int player2Score) {
        if (player1Score > player2Score) {
            return 1;
        }
        if (player1Score < player2Score) {
            return 2;
        }
        return 0;
    }

    static int getScore(List<Integer> player) {
        int maxLeftNum = maxNumber(player.get(0));
        int maxRightNum = maxNumber(player.get(1));

        return Math.max(maxLeftNum, maxRightNum);
    }

    static int maxNumber(int number) {
        int sumOfLeftNum = sumOfNumber(number);
        int multipleOfNum = multiplicationOfNumber(number);

        return Math.max(sumOfLeftNum, multipleOfNum);
    }

    static int sumOfNumber(int number) {
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    static int multiplicationOfNumber(int number) {
        int multiple = 1;

        while (number != 0) {
            multiple *= number % 10;
            number /= 10;
        }

        return multiple;
    }

    static boolean validateNum(List<Integer> player) {
        int leftNum = player.get(0);
        int rightNum = player.get(1);

        if (!isConsecutiveNum(leftNum, rightNum) || !isFirstOrLastPage(leftNum, rightNum)) {
            return false;
        }

        if (!isPositiveNum(leftNum, rightNum)) {
            return false;
        }

        return true;
    }

    static boolean isPositiveNum(int lefNum, int rightNum) {
        if (lefNum <= 0 || rightNum <= 0) {
            return false;
        }
        return true;
    }

    static boolean isConsecutiveNum(int leftNum, int rightNum) {
        if (leftNum + 1 != rightNum) {
            return false;
        }
        return true;
    }

    static boolean isFirstOrLastPage(int leftNum, int rightNum) {
        if (leftNum == FIRST_PAGE) {
            return false;
        }
        if (rightNum == LAST_PAGE) {
            return false;
        }

        return true;
    }
}
