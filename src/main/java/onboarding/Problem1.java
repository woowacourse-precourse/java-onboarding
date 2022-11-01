package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Problem1 p1 = new Problem1();
        if (!p1.validatePage(pobi) || !p1.validatePage(crong)) {
            return -1;
        }


        return answer;
    }

    private int multiply(int number) {
        int result = 1;
        while (number > 0) {
            result *= (number % 10);
            number /= 10;
        }
        return result;
    }

    private int addition(int number) {
        int result = 0;
        while (number > 0) {
            result += (number % 10);
            number /= 10;
        }
        return result;
    }

    private int getMax(int i1, int i2) {
        return Math.max(i1, i2);
    }

    private boolean validatePage(List<Integer> pages) {
        if (pages.get(0) != pages.get(1) - 1) {
            return false;
        }

        if (pages.get(0) % 2 != 1) {
            return false;
        }

        if (pages.get(1) % 2 != 0) {
            return false;
        }

        return true;
    }
}