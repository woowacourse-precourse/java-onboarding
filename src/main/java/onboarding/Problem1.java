package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 p1 = new Problem1();
        if (!p1.validatePage(pobi) || !p1.validatePage(crong)) {
            return -1;
        }

        int pobiResult = p1.getMaxNumberFromPage(pobi);
        int crongResult = p1.getMaxNumberFromPage(crong);

        if (pobiResult > crongResult) {
            return 1;
        }

        if (pobiResult < crongResult) {
            return 2;
        }

        return 0;
    }

    private int getMaxNumberFromPage(List<Integer> pages) {
        int multiply = getMax(multiply(pages.get(0)), multiply(pages.get(1)));
        int addition = getMax(addition(pages.get(0)), addition(pages.get(1)));
        return getMax(multiply, addition);
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