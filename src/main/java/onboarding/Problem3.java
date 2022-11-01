package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer += number / 10 * 3;
        answer += number % 10 / 3;

        answer += number / 100 * 30;
        answer += number % 100 / 30;

        answer += number / 1000 * 300;
        answer += number % 1000 / 300;

        return answer;
    }
}
