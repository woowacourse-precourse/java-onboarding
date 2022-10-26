package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0).intValue() + 1 != pobi.get(1).intValue() || crong.get(0).intValue() + 1 != crong.get(1).intValue()) {
            return -1;
        }

        int pobiMax = Math.max(
                Math.max(getPlusRecursive(pobi.get(0).intValue()), getMultiplyRecursive(pobi.get(0).intValue())),
                Math.max(getPlusRecursive(pobi.get(1).intValue()), getMultiplyRecursive(pobi.get(1).intValue())));
        int crongMax = Math.max(
                Math.max(getPlusRecursive(crong.get(0).intValue()), getMultiplyRecursive(crong.get(0).intValue())),
                Math.max(getPlusRecursive(crong.get(1).intValue()), getMultiplyRecursive(crong.get(1).intValue())));

        if (pobiMax - crongMax == 0) {
            return 0;
        }

        return pobiMax > crongMax ? 1 : 2;
    }

    private static int getPlusRecursive(int value) {
        if (value == 0) {
            return 0;
        }

        int result = value % 10;
        value /= 10;
        return result + getPlusRecursive(value);
    }

    private static int getMultiplyRecursive(int value) {
        if (value == 0) {
            return 1;
        }

        int result = value % 10;
        value /= 10;
        return result * getMultiplyRecursive(value);
    }
}