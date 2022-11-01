package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!checkValidity(pobi) || !checkValidity(crong)) {
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean checkValidity(List<Integer> list) {
        if (list.size() != 2) {
            return false;
        }

        for (Integer integer : list) {
            if (integer == null) {
                return false;
            }
            if (integer <= 1 || integer >= 400) {
                return false;
            }
        }

        if (list.get(1) - list.get(0) != 1) {
            return false;
        }

        if (list.get(0) % 2 != 1 || list.get(1) % 2 != 0) {
            return false;
        }

        return true;
    }

    private static int add(Integer integer) {
        int ret = 0;

        while (integer > 0) {
            ret += integer % 10;
            integer = integer / 10;
        }

        return ret;
    }

    private static int multiply(Integer integer) {
        int ret = 1;

        while (integer > 0) {
            ret *= integer % 10;
            integer = integer / 10;
        }

        return ret;
    }

    private static int getScore(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        int leftScore = Math.max(add(left), multiply(left));
        int rightScore = Math.max(add(right), multiply(right));

        return Math.max(leftScore, rightScore);
    }
}