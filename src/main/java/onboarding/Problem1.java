package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!checkPage(pobi) || !checkPage(crong)) {
            answer = -1;
        }
        return answer;
    }

    public static boolean checkPage(List<Integer> list) {
        if (list.size() != 2) return false;
        if (Math.abs(list.get(1) - list.get(0)) != 1) return false;
        return true;
    }

    public static int maxOf(Integer page) {
        int sumDigits = sumDigits(page);
        int multiplyDigits = multiplyDigits(page);
        return Math.max(sumDigits, multiplyDigits);
    }

    public static int sumDigits(int value) {
        int sum = 0;
        while (value > 0) {
            int n = value % 10;
            sum += n;
            value /= 10;
        }
        return sum;
    }

    public static int multiplyDigits(int value) {
        int multiply = 1;
        while (value > 0) {
            int n = value % 10;
            multiply *= n;
            value /= 10;
        }
        return multiply;
    }
}