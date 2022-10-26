package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for (int num = 3; num <= number; num++) {
            answer += clap(num);
        }

        return answer;
    }

    private static int clap(int number) {
        int ret = 0;
        while (number != 0) {
            if (doClap(number % 10)) {
                ret++;
            }
            number /= 10;
        }

        return ret;
    }

    private static boolean doClap(int num) {
        return num == 3 || num == 6 || num == 9;
    }
}
