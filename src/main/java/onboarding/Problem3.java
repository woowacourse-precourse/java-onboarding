package onboarding;

public class Problem3 {
    private static final int START_NUMBER = 1;

    private static final int CLAP_THREE = 3;
    private static final int CLAP_SIX = 6;
    private static final int CLAP_NINE = 9;

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int countClap(int number) {
        int result = 0;

        while (number != 0) {
            int clap = number % 10;
            if (clap == CLAP_THREE || clap == CLAP_SIX || clap == CLAP_NINE) {
                result += 1;
            }
            number /= 10;
        }

        return result;
    }
}
