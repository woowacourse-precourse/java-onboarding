package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiValue = maxOf(pobi);
        int crongValue = maxOf(crong);
        if (!hasPages(pobi) || !hasPages(crong)) {
            return -1;
        }
        if (pobiValue > crongValue) {
            answer = 1;
        }
        if (pobiValue < crongValue) {
            answer = 2;
        }
        if (pobiValue == crongValue) {
            answer = 0;
        }
        return answer;
    }

    public static boolean hasPages(List<Integer> pages) {
        if (pages.size() != 2) return false;
        if (Math.abs(pages.get(1) - pages.get(0)) != 1) return false;
        return true;
    }

    public static int maxOf(List<Integer> pages) {
        int max = Integer.MIN_VALUE;
        for (Integer page : pages) {
            int tmp = maxOf(page);
            max = Math.max(max, tmp);
        }
        return max;
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