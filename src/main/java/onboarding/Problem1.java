package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        getMultiplyOfNumber(pobi.get(0));
        getSumOfNumber(pobi.get(0));
        return answer;
    }

    private int selectMultiplyOrSumLarger (Integer targetNum){

    }

    private static int getMultiplyOfNumber(Integer targetNum) {
        int ret = 1;

        int leftNum = targetNum;
        int curPos = 10;
        while (leftNum != 0) {
            ret *= leftNum%curPos;
            leftNum /= curPos;
            curPos *= 10;
        }

        System.out.println(ret);
        return ret;
    }

    private static int getSumOfNumber(Integer targetNum) {
        int ret = 1;

        int leftNum = targetNum;
        int curPos = 10;
        while (leftNum != 0) {
            ret += leftNum%curPos;
            leftNum /= curPos;
            curPos *= 10;
        }

        System.out.println(ret);
        return ret;
    }
}