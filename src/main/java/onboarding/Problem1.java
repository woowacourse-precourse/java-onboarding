package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;
    public static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(getPageNumberException(pobi) || getPageNumberException(crong)) {
            return EXCEPTION;
        }
        return compareScore(getMaxNumber(pobi), getMaxNumber(crong));
    }

    private static int compareScore(int pobiScore, int crongScore) {
        if(pobiScore > crongScore){
            return POBI_WIN;
        } else if (pobiScore < crongScore) {
            return CRONG_WIN;
        } else {
            return DRAW;
        }
    }

    private static boolean getPageNumberException(List<Integer> page) {
        if(page.get(1) - page.get(0) != 1) {
            return true;
        }
        return false;
    }

    private static int getMaxNumber(List<Integer> page) {
        int max = 0;
        for (int i = 0; i< page.size(); i++) {
            max = Math.max(max,Math.max(pagePlus(page.get(i)), pageMultiply(page.get(i))));
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