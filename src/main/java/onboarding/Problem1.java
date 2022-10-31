package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_max = findPobiMax(pobi);
        int crong_max = findCrongMax(crong);

        if (isInputRight(pobi, crong)) {
            answer = -1;
            return answer;
        }

        answer = comparePobiAndCrong(pobi_max, crong_max);

        return answer;
    }

    private static boolean isInputRight(List<Integer> pobi, List<Integer> crong) {
        return !(exception(crong) && exception(pobi));
    }

    private static int comparePobiAndCrong(int pobi_max, int crong_max) {
        int answer=0;
        if (pobi_max > crong_max) {
            answer = 1;
        } else if (crong_max < pobi_max) {
            answer = 2;
        } else if (pobi_max == crong_max) {
            answer = 0;
        }
        return answer;
    }

    public static boolean exception(List<Integer> judge) {
        int left = judge.get(0);
        int right = judge.get(1);
        if (isContinuedPage(left, right)) {
            return false;
        } else if (isFirstOrLast(left, right)) {
            return false;
        }
        return true;
    }

    private static boolean isFirstOrLast(int left, int right) {
        return right == 400 || left == 1;
    }

    private static boolean isContinuedPage(int left, int right) {
        return Math.abs(right - left) > 1;
    }

    public static int findPobiMax(List<Integer> pobi) {

        int left_Page_Max = splitNum(pobi.get(0));
        int right_Page_Max = splitNum(pobi.get(1));

        return getMax(left_Page_Max, right_Page_Max);
    }

    public static int findCrongMax(List<Integer> crong) {
        int left_max = splitNum(crong.get(0));
        int right_max = splitNum(crong.get(1));

        return getMax(left_max, right_max);
    }

    public static int splitNum(Integer x) {
        int addSum = 0;
        int mulSum = 1;
        while (x > 0) {
            addSum += x % 10;
            mulSum *= x % 10;
            x /= 10;
        }

        int max = getMax(addSum, mulSum);
        return max;
    }

    private static int getMax(int a, int b) {
        return Math.max(a, b);
    }

}