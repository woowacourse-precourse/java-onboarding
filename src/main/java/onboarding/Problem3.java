package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if (number < 1 || number > 10000) {
            return -1;
        }

        return answer;
    }

    public static int checkLength(int num) {
        int cnt = 0;
        for (int i = num; i > 0;) {
            cnt++;
            i /= 10;
        }
        return cnt;
    }
}
