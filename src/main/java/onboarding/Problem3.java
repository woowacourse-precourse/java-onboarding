package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = getCumulativeNumberOfClap(number);
        return answer;
    }

    private static int getCumulativeNumberOfClap(int number) {
        int clap = 0;

        for (int i = 1; i <= number; i++) {
            clap += getNumberOfClap(i);
        }

        return clap;
    }

    private static int getNumberOfClap(int number) {
        int clap = 0;

        while (number > 0) {
            if ((number%10%3 == 0) && (number%10 != 0)) clap += 1;
            number /= 10;
        }

        return clap;
    }
}
