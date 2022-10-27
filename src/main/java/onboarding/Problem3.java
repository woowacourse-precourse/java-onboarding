package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (!isValidate(number)) {
            return -1;
        }
        int answer = 0;
        return answer;
    }

    public static boolean isValidate(int number) {
        return (number > 0 && number < 10001);
    }
}
