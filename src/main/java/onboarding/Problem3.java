package onboarding;

public class Problem3 {

    private static final int[] List369 = {3, 6, 9};

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }

    private static int countClap(int number) {
        int clap = 0;
        while (number > 0) {
            int res = number % 10;
            clap += is369(res);
            number /= 10;
        }
        return clap;
    }

    private static int is369(int res) {
        int cnt = 0;
        for (int s : List369) {
            if (s == res) {
                cnt++;
            }
        }
        return cnt;
    }
}
