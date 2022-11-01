package onboarding;

public class Problem3 {
    public static int solution1(int number) {
        int cnt = 0;

        while (number > 0) {
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9)
                cnt++;
            number /= 10;
        }
        return cnt;
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
