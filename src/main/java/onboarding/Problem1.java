package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isException(pobi) || isException(crong)) {
            return -1;
        }

        int pobiMaxValue = Integer.MIN_VALUE;
        int crongMaxValue = Integer.MIN_VALUE;

        for(int page : pobi) {
            pobiMaxValue = Math.max(pobiMaxValue, getSum(page));
            pobiMaxValue = Math.max(pobiMaxValue, getMultiply(page));
        }
        for(int page : crong) {
            crongMaxValue = Math.max(crongMaxValue, getSum(page));
            crongMaxValue = Math.max(crongMaxValue, getMultiply(page));
        }

        return getResult(pobiMaxValue, crongMaxValue);
    }

    private static boolean isException(List<Integer> pages) {
        if(pages.get(0) + 1 != pages.get(1)) {
            return true;
        }
        return false;
    }

    private static int getResult(int pobi, int crong) {
        if(pobi > crong) {
            return 1;
        }
        if(pobi < crong) {
            return 2;
        }
        return 0;
    }

    private static int getSum(int page) {
        int sum = 0;

        while(page > 0) {
            sum += page % 10;
            page /= 10;
        }

        return sum;
    }

    private static int getMultiply(int page) {
        int multiply = 1;

        while(page > 0) {
            multiply *= page % 10;
            page /= 10;
        }

        return multiply;
    }
}