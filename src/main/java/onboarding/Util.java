package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Integer> changeIntToIntList(int number) {
        List<Integer> result = new ArrayList<>();
        while (number != 0) {
            result.add(number % 10);
            number = number / 10;
        }
        return result;
    }
}
