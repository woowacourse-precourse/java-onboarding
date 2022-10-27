package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class BookCalculation {

    public List<Integer> calculation(List<Integer> player) {

        int addition = 0;
        int multiplication = 1;

        List<Integer> result = new ArrayList<>();

        for (int numbers : player) {
            String number = String.valueOf(numbers);
            String[] split = number.split("");


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
