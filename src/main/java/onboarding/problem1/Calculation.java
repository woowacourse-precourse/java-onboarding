package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    public static List<Integer> splitDigits(Integer integer) {
        List<Integer> splitList = new ArrayList<>();

        while (integer > 0) {
            splitList.add(integer % 10);
            integer /= 10;
        }

        return splitList;
    }

    public static Integer add(List<Integer> splitList) {
        Integer sum = 0;

        for (Integer integer : splitList) {
            sum += integer;
        }

        return sum;
    }

    public static Integer multiplication(List<Integer> splitList) {
        Integer sum = 1;

        for (Integer integer : splitList) {
            sum *= integer;
        }

        return sum;
    }
}
