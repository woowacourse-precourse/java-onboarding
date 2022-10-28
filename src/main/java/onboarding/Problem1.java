package onboarding;

import java.util.List;

import static java.lang.Integer.MIN_VALUE;
import static onboarding.Problem1. Constants.*;

class Problem1 {

    static class Constants {
        public static final int FIRST_PAGE = 0;
        public static final int LAST_PAGE = 400;
        public static final int LEFT_PAGE = 0;
        public static final int RIGHT_PAGE = 1;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (validateList(pobi) || validateList(crong)) {
            return -1;
        }

        int pobiMax = compareNumbers(pobi);
        int crongMax = compareNumbers(crong);

        if (crongMax == pobiMax) {
            return 0;
        } else if (pobiMax > crongMax) {
            return 1;
        } else {
            return 2;
        }

    }

    private static boolean validateList(List<Integer> list) {
        if (list.get(LEFT_PAGE) == null || list.get(RIGHT_PAGE) == null) {
            return true;
        }

        if (list.get(LEFT_PAGE) <= FIRST_PAGE || list.get(LEFT_PAGE) >= LAST_PAGE){
            return true;
        }

        if (list.get(RIGHT_PAGE) <= FIRST_PAGE || list.get(RIGHT_PAGE) >= LAST_PAGE) {
            return true;
        }

        if (list.get(LEFT_PAGE) % 2 != 1 || list.get(RIGHT_PAGE) % 2 != 0) {
            return true;
        }

        if (list.size() != 2) {
            return true;
        }

        return list.get(RIGHT_PAGE) - list.get(LEFT_PAGE) != 1;
    }

    private static int compareNumbers(List<Integer> numbers) {
        int addNum, multiNum;
        int max = MIN_VALUE;

        for (int number : numbers) {
            addNum = addEachNumber(number);
            multiNum = multiEachNumber(number);

            max = Math.max(max, addNum);
            max = Math.max(max, multiNum);
        }
        return max;
    }

    private static int addEachNumber(int number) {
        int sum = 0;
        while (number != 0) {
            int result = number % 10;
            sum += result;
            number /= 10;
        }
        return sum;
    }

    private static int multiEachNumber(int number) {
        int multi = 1;
        while (number != 0) {
            int result = number % 10;
            multi *= result;
            number /= 10;
        }
        return multi;
    }
}