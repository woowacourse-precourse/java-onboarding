package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        for (int i = 1; i <= number; i++) {
            int targetNumber = i;
            while (targetNumber > 0) {
                if (targetNumber % 10 == 3 || targetNumber % 10 == 6 || targetNumber % 10 == 9) {
                    clapCount++;
                }
                targetNumber /= 10;
            }
        }
        return clapCount;
    }
}
