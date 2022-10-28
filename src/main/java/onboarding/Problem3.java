package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (throwBoundaryException(number)) {
            return -1;
        }

        return answer;
    }

    public static boolean throwBoundaryException(int number) {

        if (number < 1 || number > 10000) {
            return true;
        }

        return false;
    }
}
