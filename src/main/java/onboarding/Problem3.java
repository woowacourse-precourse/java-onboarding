package onboarding;

public class Problem3 {
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
        return 0;
    }
}
