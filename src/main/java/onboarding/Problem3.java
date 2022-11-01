package onboarding;

import java.util.Vector;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            Vector<Integer> splitNumber = new Vector<>();
            int currentNumber = i;
            while (currentNumber > 0) {
                splitNumber.add(0, currentNumber % 10);
                currentNumber /= 10;
            }
            for (int digit : splitNumber) {
                if (digit == 3 || digit == 6 || digit == 9) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
