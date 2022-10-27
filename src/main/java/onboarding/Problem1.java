package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외사항
        if (isException(pobi) || isException(crong)) {
            return -1;
        }

        int pobiPoint = getMax(pobi);
        int crongPoint = getMax(crong);

        if (pobiPoint < crongPoint) {
            return 2;
        } else if (pobiPoint > crongPoint) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean isException(List<Integer> list) {
        return !isOdd(list.get(0)) || list.get(1) != list.get(0) + 1;
    }

    private static boolean isOdd(int number) {
        return number % 2 == 1;
    }

    private static int getMax(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        return Math.max(Math.max(getAdd(left), getMul(right)),
            Math.max(getAdd(right), getMul(right)));
    }

    private static int getAdd(int number) {
        int total = 0;
        while (number > 1) {
            total += number % 10;
            number /= 10;
        }
        return total;
    }

    private static int getMul(int number) {
        int total = 1;
        while (number > 1) {
            total *= number % 10;
            number /= 10;
        }
        return total;
    }
}
