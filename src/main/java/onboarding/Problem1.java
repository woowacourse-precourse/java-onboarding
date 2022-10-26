package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiLeftMax = getMaxValue(pobi.get(0));
        int pobiRightMax = getMaxValue(pobi.get(1));
        int crongLeftMax = getMaxValue(crong.get(0));
        int crongRightMax = getMaxValue(crong.get(1));

        int pobiMax = Math.max(pobiLeftMax, pobiRightMax);
        int crongMax = Math.max(crongLeftMax, crongRightMax);

        return -1;
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