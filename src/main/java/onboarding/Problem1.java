package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2 ||
                pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)) return -1;
        int pobiScore = Math.max(getMaxValBySumAndMul(pobi.get(0)), getMaxValBySumAndMul(pobi.get(1)));
        int crongScore = Math.max(getMaxValBySumAndMul(crong.get(0)), getMaxValBySumAndMul(crong.get(1)));

        if (pobiScore > crongScore) return 1;
        else if (pobiScore < crongScore) return 2;
        else return 0;
    }

    public static int getMaxValBySumAndMul(int page) {
        int sum = 0;
        int mul = 1;

        while(page > 0) {
            int currNum = page % 10;
            sum += currNum;
            mul *= currNum;
            page /= 10;
        }

        return Math.max(sum, mul);
    }
}