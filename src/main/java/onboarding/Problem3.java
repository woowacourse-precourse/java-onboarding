package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++)
            answer += clapNum(i);

        return answer;
    }

    private static int clapNum(int num) {
        return 0;
    }
}
