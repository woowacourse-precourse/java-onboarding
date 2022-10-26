package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 값을 받아 예외를 확인한다. -> isPageNumberException
 * 2. 페이지의 덧셈값과 곱셈 값을 구한다 -> pageMultiply , pagePlus
 * 3. 점수의 최대값을 구한다 -> getMaxNumber
 * 4. 최대값을 비교하여 결과를 도출한다. -> getCompareScore
 */
class Problem1 {
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;
    public static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isPageNumberException(pobi) || isPageNumberException(crong)) {
            return EXCEPTION;
        }
        return getCompareScore(getMaxNumber(pobi), getMaxNumber(crong));
    }

    private static int getCompareScore(int pobi, int crong) {
        if(pobi > crong){
            return POBI_WIN;
        } else if (pobi < crong) {
            return CRONG_WIN;
        } else {
            return DRAW;
        }
    }

    private static boolean isPageNumberException(List<Integer> page) {
        int leftPage = page.get(0);
        int rightPage = page.get(1);
        if(rightPage - leftPage != 1) {
            return true;
        }
        return false;
    }

    private static int getMaxNumber(List<Integer> page) {
        int max = 0;
        for (int i = 0; i< page.size(); i++) {
            max = Math.max(max, Math.max(pagePlus(page.get(i)), pageMultiply(page.get(i))));
        }
        return max;
    }

    private static int pageMultiply(Integer page) {
        int multiply = 1;
        while(page > 0) {
            multiply *= page % 10;
                page /= 10;
        }
        return multiply;
    }

    private static int pagePlus(Integer page) {
        int plus = 0;
        while(page > 0) {
            plus += page % 10;
            page /= 10;
        }
        return plus;
    }

}