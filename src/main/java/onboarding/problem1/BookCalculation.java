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

            //1,2,3
            for (String crrent : split) {
                addition += Integer.parseInt(crrent);
                multiplication *= Integer.parseInt(crrent);
            }

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
