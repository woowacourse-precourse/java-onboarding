package onboarding.problem3;

import java.util.ArrayList;
import java.util.List;

public class ClapGame {

    private static final List<Integer> CLAP_NUMBER = List.of(3, 6, 9);

    public int getClap(int number) {
        int clap = 0;
        for (int i = 1; i <= number; i++) {
            List<Integer> digits = getDigitList(i);
            clap += getDigitsClap(digits);
        }
        return clap;
    }

    private int getDigitsClap(List<Integer> digits) {
        int clap = 0;
        for (Integer digit : digits) {
            if (isClapNumber(digit)) {
                clap++;
            }
        }
        return clap;
    }

    private boolean isClapNumber(Integer num) {
        return CLAP_NUMBER.contains(num);
    }

    private List<Integer> getDigitList(int number) {
        List<Integer> digitList = new ArrayList<>();

        while (number != 0) {
            digitList.add(number % 10);
            number /= 10;
        }

        return digitList;
    }
}
