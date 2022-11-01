package onboarding;

public class Problem3 {
    public static int countTargetNumber(int targetNumber) {
    }

    public static int solution(int number) {
        int answer = 0;
        for (int targetNumber = 1; targetNumber <= number; targetNumber++) {
            answer += countTargetNumber(targetNumber);
        }

        return answer;
    }
}
