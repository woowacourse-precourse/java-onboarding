package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class BookCalculation {

    public List<Integer> calculation(List<Integer> player) {

        int addition = 0;
        int multiplication = 0;

        List<Integer> result = new ArrayList<>();

        for (int number : player) {

            int first = number / 100;
            int second = (number / 10) % 10;
            int third = number % 10;

            addition = first + second + third;
            multiplication = first * second * third;

            result.add(addition);
            result.add(multiplication);
        }

        return result;
    }

    public int maxNumber(List<Integer> player) {

        return 0;
    }
}
