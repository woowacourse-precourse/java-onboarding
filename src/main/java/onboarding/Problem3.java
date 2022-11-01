package onboarding;

public class Problem3 {
    public static int countTargetNumber(int targetNumber) {
        int cumulativeCount = 0;
        int exponent = (Integer.toString(targetNumber).length() - 1);

        while (exponent >= 0) {
            int digit = (int) Math.pow(10, exponent);
            int target = targetNumber / digit;
            if (target == 3 || target == 6 || target == 9) {
                cumulativeCount++;
            }

            targetNumber %= digit;
            exponent--;
        }

        return cumulativeCount;
    }

    public static int solution(int number) {
        int answer = 0;
        for (int targetNumber = 1; targetNumber <= number; targetNumber++) {
            answer += countTargetNumber(targetNumber);
        }

        return answer;
    }
}
