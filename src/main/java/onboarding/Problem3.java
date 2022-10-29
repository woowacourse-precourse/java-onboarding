package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int clapCount(int value) {

        if (value / 10 == 0) {
            return clap(value);
        }

        return clapCount(value / 10) + clap(value % 10);
    }
    public static int clap(int value) {
        if (value == 3 || value == 6 || value == 9) {
            return 1;
        } else {
            return 0;
        }
    }
}
