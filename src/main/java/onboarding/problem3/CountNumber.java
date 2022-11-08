package onboarding.problem3;

import java.util.ArrayList;
import java.util.List;

public class CountNumber {
    public static int getCount(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            List<Integer> splitList = splitNumber(i);
            count = count + countNumber(splitList);
        }

        return count;
    }

    private static int countNumber(List<Integer> splitList) {
        int countContain = 0;

        for (Integer integer : splitList) {
            countContain += numberOfContain(integer);
        }

        return countContain;
    }

    private static int numberOfContain(Integer integer) {
        int count = 0;

        if (integer == 3 || integer == 6 || integer == 9) {
            count++;
        }

        return count;
    }


    public static List<Integer> splitNumber(int number) {
        List<Integer> splitList = new ArrayList<>();

        while (number > 0) {
            splitList.add(number % 10);
            number /= 10;
        }

        return splitList;
    }
}
