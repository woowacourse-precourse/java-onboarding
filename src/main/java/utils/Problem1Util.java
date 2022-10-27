package utils;

import java.util.List;

public class Problem1Util {
    public static int getMaxBetweenSumAndMultiply(List<Integer> nums) {
        int result = Integer.MIN_VALUE;
        for (Integer num : nums) {
            result = isMax(result, num);
        }
        return result;
    }

    private static int isMax(int result, Integer num) {
        int sum = 0, mult = 1;
        while (num > 0) {
            int tmp = num % 10;
            sum += tmp;
            mult *= tmp;
            num /= 10;
        }
        result = Math.max(result, sum);
        result = Math.max(result, mult);
        return result;
    }
}
