package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 3; i <= number; i++) {
            answer += getClapCount(i);
        }

        return answer;
    }

    public static int getClapCount(int number) {
        int clap = 0;
        while (number != 0) {
            if (isMatch(number % 10)) {
                clap++;
            }
            number /= 10;
        }
        return clap;
    }

    public static boolean isMatch(int digit) {
        return true;
    }
}
