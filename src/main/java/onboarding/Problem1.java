package onboarding;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
class Problem1 {
    private static final int START_PAGE_LIMIT = 1;
    private static final int END_PAGE_LIMIT = 400;
    private static final int PAGE_SIZE = 2;
    private static final int ONE_PAGE = 1;
    private static final char CHAR_ZERO = '0';
    private static final int USER1_WINNER = 1;
    private static final int USER2_WINNER = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (validationCheck(pobi, crong)) {
            int pobi_max = getMaxValue(pobi);
            int crong_max = getMaxValue(crong);
            int winner = getWinner(pobi_max, crong_max);
            return winner;
        }
        return EXCEPTION;
    }
    public static boolean validationCheck(List<Integer> user_1, List<Integer> user_2) {
        int user1Left = user_1.get(LEFT_PAGE);
        int user1Right = user_1.get(RIGHT_PAGE);
        int user2Left = user_2.get(LEFT_PAGE);
        int user2Right = user_2.get(RIGHT_PAGE);
        int user1Size = user_1.size();
        int user2Size = user_2.size();

        if (user_1.contains(START_PAGE_LIMIT) || user_1.contains(END_PAGE_LIMIT) ||
                user_2.contains(START_PAGE_LIMIT) || user_2.contains(END_PAGE_LIMIT)) {
            return false;
        } else if (user1Left < START_PAGE_LIMIT || user1Right > END_PAGE_LIMIT ||
                user2Left < START_PAGE_LIMIT || user2Right > END_PAGE_LIMIT) {
            return false;
        } else if (user1Right != user1Left + ONE_PAGE ||
                user2Right != user2Left + ONE_PAGE) {
            return false;
        } else if (user1Left % PAGE_SIZE != 1 ||
                user2Left % PAGE_SIZE != 1) {
            return false;
        } else if (user1Size != PAGE_SIZE || user2Size != PAGE_SIZE) {
            return false;
        }
        return true;
    }

    public static int getMaxValue(List<Integer> user) {
        String leftPage = Integer.toString(user.get(LEFT_PAGE));
        String rightPage = Integer.toString(user.get(RIGHT_PAGE));

        int[] left = {ZERO, ONE};
        int[] right = {ZERO, ONE};
        for (int i = ZERO; i < leftPage.length(); i++) {
            left[ZERO] += (leftPage.charAt(i) - CHAR_ZERO);
            left[ONE] *= (leftPage.charAt(i) - CHAR_ZERO);
        }
        for (int i = ZERO; i < rightPage.length(); i++) {
            right[ZERO] += (rightPage.charAt(i) - CHAR_ZERO);
            right[ONE] *= (rightPage.charAt(i) - CHAR_ZERO);
        }
        int biggest = ZERO;
        for (int i = ZERO; i < left.length; i++) {
            if (left[i] > biggest) {
                biggest = left[i];
            }
            if (right[i] > biggest) {
                biggest = right[i];
            }
        }
        return biggest;
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