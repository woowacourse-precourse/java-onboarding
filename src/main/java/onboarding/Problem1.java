package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            return -1;
        }

        int pobiValue = Math.max(getMaxNum(pobi.get(0)), getMaxNum(pobi.get(1)));
        int crongValue = Math.max(getMaxNum(crong.get(0)), getMaxNum(crong.get(1)));

        if(pobiValue == crongValue){
            return 0;
        }

        return (pobiValue > crongValue) ? 1 : 2;
    }

    /**
     * 각 자리수를 더하거나 곱한 수 중 큰값 추출
     */
    private static int getMaxNum(int page){
        int sum = 0;
        int mul = 1;
        int maxNum;

        while (page > 0){
            sum += page%10;
            mul *= page%10;
            page /= 10;
        }

        maxNum = Math.max(sum, mul);

        return maxNum;
    }

}