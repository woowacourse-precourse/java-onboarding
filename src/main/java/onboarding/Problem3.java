package onboarding;

public class Problem3 {

    public static int get369Count(int number) {
        int cnt = 0;

        while (number > 0) {
            int currDigit = number % 10;
            if (currDigit % 3 == 0) cnt++;
            number /= 10;
        }

        return cnt;
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
