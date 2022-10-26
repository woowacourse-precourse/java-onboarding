package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    static int LEN_NUMBER_OF_DIGITS = 3;

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

    private static int[] intToArr(int page) {
        int[] arr = new int[LEN_NUMBER_OF_DIGITS];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (page % (int) Math.pow(10, i + 1)) / (int) Math.pow(10, i);
        }
        return arr;
    }

}