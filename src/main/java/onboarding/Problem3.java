package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (!validateGameNumber(number)) {
            return -1;
        }
        int answer = 0;
        return answer;
    }

    public static boolean validateGameNumber(int number) {
        if (number < 1 || number > 10000) {
            return false;
        }
        return true;
    }
}
