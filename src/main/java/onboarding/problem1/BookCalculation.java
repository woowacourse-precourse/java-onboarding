package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class BookCalculation {

    public List<Integer> calculation(List<Integer> player) {

        List<Integer> result = new ArrayList<>();

        for (int number : player) {

            int first = number / 100;
            int second = (number / 10) % 10;
            int third = number % 10;

            int addition = first + second + third;
            int multiplication = first * second * third;

            result.add(addition);
            result.add(multiplication);
        }

        return result;
    }

    public int maxNumber(List<Integer> player) {

        int max = 0;

        for (int number : player) {
            if (max < number) {
                max = number;
            }
        }

        return max;
    }
}
