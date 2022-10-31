package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;

        for (int n = 1; n < number + 1; n++) {
            cnt += numClap(n);
        }

        return cnt;
    }

    static int numClap(int number) {
        int cnt = 0;
        int remain;

        while (number > 0) {
            remain = number % 10;
            if (remain == 3 || remain == 6 || remain == 9) {
                cnt++;
            }
            number /= 10;
        }

        return cnt;
    }
}
