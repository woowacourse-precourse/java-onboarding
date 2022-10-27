package onboarding;

import java.util.List;
import java.util.Arrays;

class Problem1 {
    private static final int LEFT_PAGE_LIMIT = 1;
    private static final int RIGHT_PAGE_LIMIT = 400;
    private static final int PAGE_SIZE = 2;
    private static final int ONE_PAGE = 1;
    private static final char CHAR_ZERO = '0';
    private static final int USER1_WINNER = 1;
    private static final int USER2_WINNER = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1; // 시스템 상수
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (validationCheck(pobi) && validationCheck(crong)) {
            int pobi_max = getMaxValue(pobi);
            int crong_max = getMaxValue(crong);
            int winner = getWinner(pobi_max, crong_max);
            return winner;
        }
        return EXCEPTION;
    }
    public static boolean validationCheck(List<Integer> user) {
        int leftPage = user.get(LEFT_PAGE);
        int rightPage = user.get(RIGHT_PAGE);
        int pageSize = user.size();

        if (leftPage <= LEFT_PAGE_LIMIT || rightPage >= RIGHT_PAGE_LIMIT) {
            return false;
        } else if (rightPage != leftPage + ONE_PAGE) {
            return false;
        } else if (leftPage % PAGE_SIZE != 1) {
            return false;
        } else if (pageSize != PAGE_SIZE) {
            return false;
        }
        return true;
    }

    public static int getMaxValue(List<Integer> user) {
        int leftPage = user.get(LEFT_PAGE);
        int rightPage = user.get(RIGHT_PAGE);
        int[] allPossibleValues = {getSum(leftPage),
                getSum(rightPage),
                getMult(leftPage),
                getMult(rightPage)};
        int biggest = 0;
        for (int element : allPossibleValues) {
            if (biggest < element) {
                biggest = element;
            }
        }
        return biggest;
    }

    public static int getSum(int number) {
        int result = 0;
        while (number != 0) {
            result += (number % 10);
            number /= 10;
        }
        return result;
    }

    public static int getMult(int number) {
        int result = 1;
        while (number != 0) {
            result *= (number % 10);
            number /= 10;
        }
        return result;
    }
    public static int getWinner(int user_1, int user_2) {
        if (user_1 > user_2) {
            return USER1_WINNER;
        }
        else if (user_1 < user_2) {
            return USER2_WINNER;
        }
        return DRAW;
    }
}