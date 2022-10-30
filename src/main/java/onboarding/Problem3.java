package onboarding;

public class Problem3 {
    public static int solution(int number) {
        final int ERROR = -1;
        if (!validation(number)) return ERROR;
        int answer = 0;
        return answer;
    }

    static boolean validation(int number) {
        return number >= 1 && number <= 10000;
    }
}
