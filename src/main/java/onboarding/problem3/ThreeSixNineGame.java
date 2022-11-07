package onboarding.problem3;

import java.util.stream.IntStream;

public class ThreeSixNineGame {

    public int do369(int number) {
        return IntStream.range(1, number + 1)
                .map(this::count369)
                .sum();
    }

    private int count369(int number) {
        int count = 0;

        while (number > 0) {
            int num = number % 10;
            if (num == 3 || num == 6 || num == 9) {
                count++;
            }

            number /= 10;
        }

        return count;
    }
}
