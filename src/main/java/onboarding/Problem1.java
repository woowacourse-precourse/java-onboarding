package onboarding;

import java.util.List;

class Problem1 {
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int DRAW = 0;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
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

    public static int getMaxNumber(List<Integer> page) {
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
}