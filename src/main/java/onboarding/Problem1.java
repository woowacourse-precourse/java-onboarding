package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isSuccessiveInt(pobi) && isSuccessiveInt(crong)) {

        }
        return -1;
    }

    private static int multipleDigit(int num) {
        int result = 1;

        while (num > 0) {
            result *= num % 10;
            num /= 10;
        }
        return result;
    }

    private static int addDigit(int num) {
        int result = 0;

        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    private static boolean isSuccessiveInt(List<Integer> pageIntegerList) {
        return pageIntegerList.get(1) == pageIntegerList.get(0) + 1;
    }
}