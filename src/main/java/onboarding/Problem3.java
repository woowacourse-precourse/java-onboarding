package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        for (int i = 1; i <= number; i++) {
            int currentNumber = i;
            while (currentNumber != 0 ) {
                int digit = currentNumber % 10;
                if(digit == 3 || digit == 6 || digit == 9 ) {
                    clapCount++;
                }
                currentNumber /= 10;
            }
        }
        return clapCount;
    }
}
