package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int curNum = i;

            while (curNum > 0) {
                int digit = curNum % 10;
                if (is369(digit)) {
                    answer += 1;
                }
                curNum /= 10;
            }
        }

        return answer;
    }

    private static boolean is369(int digit) {
        if (digit == 3 || digit == 6 || digit == 9) {
            return true;
        }
        return false;
    }
}
