package onboarding;

public class Problem3 {
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
        return digit == 3 || digit == 6 || digit == 9;
    }
}
