package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        for (int turn = 1; turn <= number; turn++) {
            clapCount += count369ByNumber(turn);
        }
        return clapCount;
    }

    private static int count369ByNumber(int number) {
        return (int) String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .filter(digit -> is369(digit))
                .count();
    }

    private static boolean is369(int digit) {
        return digit == 3 || digit == 6 || digit == 9;
    }
}
