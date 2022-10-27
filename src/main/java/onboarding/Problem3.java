package onboarding;

public class Problem3 {
    static String numCheck(int number) {
        String exception="";
        if(number < 1 || number > 1000) {
            exception = "범위 오류";
        }
        return exception;
    }

    public static int solution(int number) {
        int answer = 0;
        numCheck(number);
        return answer;
    }
}