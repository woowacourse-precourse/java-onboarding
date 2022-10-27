package utils;

import java.util.List;

public class Problem1Util {
    public static int getMaxBetweenSumAndMultiply(List<Integer> nums) {
        if (!isValid(nums)) return -1;
        int result = Integer.MIN_VALUE;
        for (Integer num : nums) {
            result = isMax(result, num);
        }
        return result;
    }

    private static boolean isValid(List<Integer> nums) {
        if (nums.size() != 2) return false; //  input되는 숫자가 두 개인가
        if (nums.get(1) - nums.get(0) != 1) return false; // 연속된 두 숫자인가
        for (int i = 0; i < 2; i++) {
            if (nums.get(i) % 2 != 1 - i) {
                return false; // 해당 숫자가 [홀수, 짝수]인가
            }
        }
        return true;
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

    public static int whoIsWinner(int pobiResult, int crongResult) {
        if (pobiResult == -1 || crongResult == -1) return -1; // 주의
        else if (pobiResult > crongResult) return 1;
        else if (pobiResult < crongResult) return 2;
        return 0;
    }
}
