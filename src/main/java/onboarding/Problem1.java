package onboarding;

import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isPageNullException(pobi) || isPageNullException(crong)) {
            return EXCEPTION;
        }
        if(isPageEmptyException(pobi) || isPageEmptyException(crong)) {
            return EXCEPTION;
        }
        if(isPageNumberException(pobi) || isPageNumberException(crong)) {
            return EXCEPTION;
        }
        return getCompareScore(getMaxNumber(pobi), getMaxNumber(crong));
    }
    private static int pageMultiply(Integer page) {
        int multiply = 1;
        while(page > 0) {
            int digit = page % 10;
            multiply = Math.multiplyExact(multiply, digit);
            page /= 10;
        }
        return multiply;
    }

    private static int pagePlus(Integer page) {
        int plus = 0;
        while(page > 0) {
            int digit = page % 10;
            plus = Math.addExact(plus, digit);
            page /= 10;
        }
        return plus;
    }

    private static int getMaxNumber(List<Integer> page) {
        int max = 0;
        for (int i = 0; i< page.size(); i++) {
            max = Math.max(max, Math.max(pagePlus(page.get(i)), pageMultiply(page.get(i))));
        }
        return max;
    }

    private static int getCompareScore(int pobi, int crong) {
        if(pobi > crong){
            return POBI_WIN;
        }
        if (pobi < crong) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    public static boolean isPageNumberException(List<Integer> page) {
        Integer leftPage = page.get(0);
        Integer rightPage = page.get(1);

        if(rightPage - leftPage != 1) {
            return true;
        }
        return false;
    }

    public static boolean isPageNullException(List<Integer> page) {
        Integer leftPage = page.get(0);
        Integer rightPage = page.get(1);

        if(rightPage == null || leftPage == null) {
            return true;
        }
        return false;
    }

    public static boolean isPageEmptyException(List<Integer> page) {
        if(page.isEmpty()) {
            return true;
        }
        return false;
    }
}