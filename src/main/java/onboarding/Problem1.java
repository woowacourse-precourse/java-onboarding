package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        System.out.println(selectLargerPageResult(pobi));
        return answer;
    }
    

    private static int selectLargerPageResult(List<Integer> target){
        Integer left = selectMultiplyOrSumLarger(target.get(0));
        Integer right = selectMultiplyOrSumLarger(target.get(1));

        return Math.max(left, right);
    }

    private static Integer selectMultiplyOrSumLarger (Integer targetNum){
        int multiplyResult = getMultiplyOfNumber(targetNum);
        int sumResult = getSumOfNumber(targetNum);

        return Math.max(multiplyResult, sumResult);
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

        return ret;
    }
}