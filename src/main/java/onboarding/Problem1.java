package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        return answer;
    }

    /**
     * 각 자리수를 더하거나 곱한 수 중 큰값 추출
     */
    private int getMaxNum(int page){
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