package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(97);
        list1.add(98);
        list2.add(197);
        list2.add(198);

        System.out.println(solution(list1, list2));
    }
    static final int LEN_NUMBER_OF_DIGITS = 3;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = calcScore(pobi);
        int crongScore = calcScore(crong);

        System.out.println("pobiScore = " + pobiScore);;
        System.out.println("crongScore = " + crongScore);

        if (pobiScore == Integer.MAX_VALUE || crongScore == Integer.MAX_VALUE) {
            return -1;
        }

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }

    private static int operMulti(int[] arr) {
        int result = 1;
        boolean numberStart = false;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == 0 && !numberStart) {
                continue;
            }else if (arr[i] != 0 && !numberStart) {
                numberStart = true;
            }
            result *= arr[i];
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
        System.out.println(page + " " + Arrays.toString(arr));
        return arr;
    }

    private static int calcScore(List<Integer> pages) {
        int score = Integer.MIN_VALUE;
        for (Integer page : pages) {
            score = Math.max(score, compareScore(intToArr(page)));
        }
        return score;
    }
}