package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (errorCheck(pobi, crong)) {
            return -1;
        }

        int pobiLeftMax = getMaxValue(pobi.get(0));
        int pobiRightMax = getMaxValue(pobi.get(1));
        int crongLeftMax = getMaxValue(crong.get(0));
        int crongRightMax = getMaxValue(crong.get(1));

        int pobiMax = Math.max(pobiLeftMax, pobiRightMax);
        int crongMax = Math.max(crongLeftMax, crongRightMax);

        return getWinner(pobiMax, crongMax);
    }

    private static boolean errorCheck(List<Integer> pobi, List<Integer> crong) {
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (pobiLeft % 2 != 1 || crongLeft % 2 != 1) {
            return true;
        }
        if (pobiRight % 2 != 0 || crongRight % 2 != 0) {
            return true;
        }

        return false;
    }

    private static int getWinner(int pobiMax, int crongMax) {
        if (pobiMax > crongMax) {
            return 1;
        }
        if (pobiMax < crongMax) {
            return 2;
        }

        return 0;
    }

    private static int getMaxValue(int page) {
        int sum = 0;
        int mul = 1;
        int seatNum;

        while (page > 0) {
            seatNum = page % 10;
            page /= 10;
            sum += seatNum;
            mul *= seatNum;
        }

        return Math.max(sum, mul);
    }
}