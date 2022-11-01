package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (checkValue(pobi) || checkValue(crong)) {
            return -1;
        }

        int pobiMax = Math.max(calcMax(pobi.get(0)), calcMax(pobi.get(1)));
        int crongMax = Math.max(calcMax(crong.get(0)), calcMax(crong.get(1)));

        if (crongMax < pobiMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        }
        return 0;
    }

    public static boolean checkValue(List<Integer> list) {

        int left = list.get(0);
        int right = list.get(1);

        if (left < 1 || 400 <= left) {
            return true;
        }
        if (right <= 1 || 400 < right) {
            return true;
        }
        if (left % 2 != 1) {
            return true;
        }
        if (right - left != 1) {
            return true;
        }
        return false;
    }
    public static int calcMax(int value) {

        int valueSum = 0;
        int valueMul = 1;

        while (value / 10 > 0) {
            int digit = value % 10;

            valueSum += digit;
            valueMul *= digit;
            value /= 10;
        }
        valueSum += value;
        valueMul *= value;

        return Math.max(valueSum, valueMul);
    }
}