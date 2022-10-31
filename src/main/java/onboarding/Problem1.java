package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (exceptions(pobi) || exceptions(crong)) {
            return -1;
        }
        int pobiLeft = Math.max(sum_plus(pobi.get(0)), sum_multiply(pobi.get(0)));
        int pobiRight = Math.max(sum_plus(pobi.get(1)), sum_multiply(pobi.get(1)));
        int crongLeft = Math.max(sum_plus(crong.get(0)), sum_multiply(crong.get(0)));
        int crongRight = Math.max(sum_plus(crong.get(1)), sum_multiply(crong.get(1)));

        int pobi_point = Math.max(pobiLeft, pobiRight);
        int crong_point = Math.max(crongLeft, crongRight);

        return pobi_point > crong_point ? 1 : (pobi_point < crong_point) ? 2 : 0;
    }

    public static boolean exceptions(List<Integer> person) {
        int left = person.get(0);
        int right = person.get(1);
        if (left < 1 || left > 400 || right < 1 || right > 400) {
            return true;
        }
        if (left % 2 == 0 || right % 2 == 1) {
            return true;
        }
        return left + 1 != right;
    }

    public static int maxPoint(List<Integer> point) {
        int maxScore = Integer.MIN_VALUE;
        for (Integer num : point) {
            if (maxScore < num) {
                maxScore = num;
            }
        }
        return maxScore;
    }

    public static int sum_plus(int page) {
        int sum = 1;
        while (page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    public static int sum_multiply(int page) {
        int sum = 1;
        while (page > 0) {
            sum *= page % 10;
            page /= 10;
        }
        return sum;
    }
}