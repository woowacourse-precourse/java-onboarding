package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        final int pageMin = 1;
        final int pageMax = 400;
        final int pobiWin = 1;
        final int crongWin = 2;
        final int draw = 0;
        final int error = -1;

        int pobiLeft, pobiRight, crongLeft, crongRight;
        int pobiScore, crongScore;

        pobiLeft = pobi.get(0);
        pobiRight = pobi.get(1);
        crongLeft = crong.get(0);
        crongRight = crong.get(1);

        if (pobiLeft < pageMin || pobiRight > pageMax) {
            return error;
        }

        if (crongLeft < pageMin || crongRight > pageMax) {
            return error;
        }

        if (pobiLeft % 2 != 1 || crongLeft % 2 != 1) {
            return error;
        }

        if (pobiRight != pobiLeft + 1 || crongRight != crongLeft + 1) {
            return error;
        }

        pobiScore = Math.max(getScore(pobiLeft), getScore(pobiRight));
        crongScore = Math.max(getScore(crongLeft), getScore(crongRight));

        if (pobiScore > crongScore) {
            return pobiWin;
        }

        if (crongScore > pobiScore) {
            return crongWin;
        }

        return draw;
    }

    public static int getScore(int page) {
        int digit;
        int sum = 0;
        int mul = 1;

        while (page > 0) {
            digit = page % 10;
            sum += digit;
            mul *= digit;
            page /= 10;
        }

        return Math.max(sum, mul);
    }
}