package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> a, List<Integer> b) {
        return whoIsWinner(getMaxBetweenSumAndMultiply(a), getMaxBetweenSumAndMultiply(b));
    }

    public static int getMaxBetweenSumAndMultiply(List<Integer> nums) {
        if (!isValid(nums)) return -1;
        int result = Integer.MIN_VALUE;
        for (Integer num : nums) {
            result = isMax(result, num);
        }
        return result;
    }

    private static boolean isValid(List<Integer> nums) {
        if (!isValidLength(nums)) return false; //  input되는 숫자가 두 개인가
        if (!isSequenceNum(nums)) return false; // 연속된 두 숫자인가
        if (!isInRange(nums)) return false; // 해당 숫자가 [홀수, 짝수]인가
        return true;
    }

    private static boolean isValidLength(List<Integer> nums) {
        return nums.size() == 2;
    }

    private static boolean isSequenceNum(List<Integer> nums) {
        return nums.get(1) - nums.get(0) == 1;
    }

    private static boolean isInRange(List<Integer> nums) {
        for (int i = 0; i < 2; i++) {
            Integer num = nums.get(i);
            if (!inBound(num)) return false;
            if (!oddAndEven(i, num)) return false;
        }
        return true;
    }

    private static boolean inBound(Integer num) {
        return num > 1 && num < 400;
    }

    private static boolean oddAndEven(int i, Integer num) {
        return num % 2 == 1 - i;
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

    public static int whoIsWinner(int a, int b) {
        if (a == -1 || b == -1) return -1; // 주의
        else if (a > b) return 1;
        else if (a < b) return 2;
        return 0;
    }
}