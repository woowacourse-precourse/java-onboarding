package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += clapCount(i);
        }
        return answer;
    }

    private static int clapCount(int i) {
        int r = 0;
        for (int t = 0; t < 5; t++) {
            if(i == 0) break;
            int digit = i % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                r += 1;
            }
            i /= 10;
        }
        return r;
    }
}
