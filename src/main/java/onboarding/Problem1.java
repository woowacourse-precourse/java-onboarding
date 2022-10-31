package onboarding;

import java.util.List;

class Problem1 {
    final static int EXCEPTION = -1;
    final static int POBI_WIN = 1;
    final static int CRONG_WIN = 2;
    final static int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore;
        int crongScore;

        if (!(checkPage(pobi) && checkPage(crong))) {
            return EXCEPTION;
        }
        if (!(validation(pobi) && validation(crong))) {
            return EXCEPTION;
        }

        pobiScore = getMax(sum(pobi.get(0)), mul(pobi.get(1)));
        crongScore = getMax(sum(crong.get(0)), mul(crong.get(1)));

        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (crongScore > pobiScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    private static boolean checkPage(List<Integer> page) {
        return page.get(1) - page.get(0) == 1;
    }

    private static boolean validation(List<Integer> page) {
        return page.get(0) != 1 && page.get(1) != 400;
    }

    private static int sum(Integer page) {
        int sum = 0;
        String num = Integer.toString(page);

        for (int i = 0; i < num.length(); i++) {
            sum += Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return sum;
    }

    private static int mul(Integer page) {
        int mul = 1;
        String num = Integer.toString(page);

        for (int i = 0; i < num.length(); i++) {
            mul *= Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return mul;
    }

    private static int getMax(Integer left, Integer right) {
        int leftMax = Math.max(sum(left), mul(left));
        int rightMax = Math.max(sum(right), mul(right));
        return Math.max(leftMax, rightMax);
    }
}