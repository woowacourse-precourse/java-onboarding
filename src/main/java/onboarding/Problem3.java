package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;
        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            int temp = currentNumber;
            while (temp != 0) {
                int unitDigit = temp % 10;
                if (unitDigit == 3 || unitDigit == 6 || unitDigit == 9 ) clapCount++;
                temp /= 10;
            }
        }
        return clapCount;
    }
}
