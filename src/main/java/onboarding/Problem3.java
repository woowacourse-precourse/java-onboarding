package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clap = 0;

        for (int i = 1; i <= number; i++) {
            int currentNumber = i;
            int remainderOfCurrentNumber;

            while (currentNumber != 0) {
                remainderOfCurrentNumber = currentNumber % 10;
                if (remainderOfCurrentNumber == 3 || remainderOfCurrentNumber == 6 || remainderOfCurrentNumber == 9)
                    clap++;
                currentNumber /= 10;
            }
        }
        return clap;
    }
}
