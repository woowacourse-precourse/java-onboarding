package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    static int calcTotalSum(int pageNum) {
        int totalSum = 0;

        while (pageNum > 0) {
            int lastNum = pageNum % 10;
            totalSum += lastNum;
            pageNum = pageNum / 10;
        }

        return totalSum;
    }
}