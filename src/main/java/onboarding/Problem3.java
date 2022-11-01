package onboarding;

public class Problem3 {
    private static final int THREE = 3;
    private static final int SIX = 6;
    private static final int NINE = 9;

    public static int solution(int number) {
        return countClapsFrom1ToNumber(number);
    }

    private static int countClapsFrom1ToNumber(int number) {
        int clapCount = 0;
        for (int turn = 1; turn <= number; turn++) {
            clapCount += countClaps(turn);
        }
        return clapCount;
    }

    private static int countClaps(int turn) {
        return (int) String.valueOf(turn)
                .chars()
                .map(Character::getNumericValue)
                .filter(digit -> has369(digit))
                .count();
    }

    private static boolean has369(int digit) {
        return digit == THREE || digit == SIX || digit == NINE;
    }
}
