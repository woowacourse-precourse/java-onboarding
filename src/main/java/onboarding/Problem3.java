package onboarding;

import java.util.List;

public class Problem3 {

    public static final List<Integer> THREE_SIX_NINE = List.of(3, 6, 9);

    public static int solution(int number) {
        return playGame(number);
    }

    private static int playGame(int number) {
        int result = 0;

        for (int i = 1; i <= number; i++) {
            result += countClap(i);
        }

        return result;
    }

    private static int countClap(int checkNum) {
        int count = 0;

        while (checkNum > 1) {
            if (THREE_SIX_NINE.contains(checkNum % 10)) {
                count++;
            }
            checkNum /= 10;
        }

        return count;
    }

}
