package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidData(pobi) || !isValidData(crong)) {
            return -1;
        }

        int pobiMax = getScore(pobi);
        int crongMax = getScore(crong);

        if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        } else {
            return 0;
        }
    }

    private static boolean isValidData(List<Integer> list) {
        if (list.size() != 2) {
            return false;
        }
        if (list.get(0) % 2 != 1 || list.get(1) % 2 != 0) {
            return false;
        }
        if (list.get(0) == 1 || list.get(1) == 400) {
            return false;
        }
        return list.get(0) + 1 == list.get(1);
    }

    private static int getScore(List<Integer> list) {
        return Math.max(getMax(list.get(0)), getMax(list.get(1)));
    }

    private static int getMax(Integer num) {
        int[] ints =
                Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(ints).sum();
        int mul = 1;
        for (int i : ints) {
            mul *= i;
        }
        return Math.max(sum, mul);
    }
}