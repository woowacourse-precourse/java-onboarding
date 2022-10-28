package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if (number < 1 || number > 10000) {
            return -1;
        }

        for (int i = 1; i <= number; i++) {
            answer += countNum(i);
        }

        return answer;
    }

    public static int countNum(int num) {
        int cnt = 0;
        for (int i = num; i > 0;) {
            if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                cnt++;
            }
            i /= 10;
        }
        return cnt;
    }
}
