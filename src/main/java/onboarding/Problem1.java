package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        answer = selectWinner(pobi, crong);

        return answer;
    }

    private static int selectWinner(List<Integer> firstTarget, List<Integer> secondTarget){
        int firstTargetResult = selectLargerPageResult(firstTarget);
        int secondTargetResult = selectLargerPageResult(secondTarget);

        return Integer.compare(firstTargetResult, secondTargetResult);

    }



    private static int selectLargerPageResult(List<Integer> target){
        Integer left = selectMultiplyOrSumLarger(target.get(0));
        Integer right = selectMultiplyOrSumLarger(target.get(1));

        if (left > right){
            return 1;
        } else if (left.equals(right)) {
            return 0;
        } else {
            return  2;
        }
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
        }

        return ret;
    }

    private static int getSumOfNumber(Integer targetNum) {
        int ret = 0;

        int leftNum = targetNum;
        int curPos = 10;
        while (leftNum != 0) {
            ret += leftNum%curPos;
            leftNum /= curPos;
        }

        return ret;
    }
}