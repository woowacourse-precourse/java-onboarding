package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = start(number);
        return answer;
    }

    private static int start(int number) {
        int answer = 0;
        for (int i = 1; i <= number; ++i) {
            answer += isContain369(i);
        }
        return answer;
    }
}
