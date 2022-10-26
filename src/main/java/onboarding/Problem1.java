package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> 현crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int operMulti(int[] arr) {
        int result = 1;
        for (int num : arr) {
            result *= num;
        }
        return result;
    }

    private static int operPlus(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result += num;
        }
        return result;
    }

    private static int compareScore(int[] arr) {
        return Math.max(operMulti(arr), operPlus(arr));
    }

}