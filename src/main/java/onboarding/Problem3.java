package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
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
