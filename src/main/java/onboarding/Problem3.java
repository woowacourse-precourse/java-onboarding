package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (checkValidation(number)) {

        } else {
            answer = -1;
        }

        return answer;
    }

    private static boolean checkValidation(int inputNumber) {
        // 1 이상 40,000 이하인 자연수인지 확인하다.
        if (1 <= inputNumber && inputNumber <= 40000) {
            return false;
        }

        return true;
    }
}
