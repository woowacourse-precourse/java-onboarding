package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int highestNum(List<Integer> pobi) {
        int leftNum = pobi.get(0);
        int rightNum = pobi.get(1);

        int leftNumSum = 0;
        int leftNumMul = 0;
        while (leftNum != 0) {
            leftNumSum += leftNum % 10;
            leftNumMul *= leftNum % 10;
            leftNum /= 10;
        }
        int rightNumSum = 0;
        int rightNumMul = 0;
        while (rightNum != 0) {
            rightNumSum += rightNum % 10;
            rightNumMul *= rightNum % 10;
            rightNum /= 10;
        }
        int highestLeftNum = leftNumMul > leftNumSum ? leftNumMul : leftNumSum;
        int highestRightNum = rightNumMul > rightNumSum ? rightNumMul : rightNumSum;
        return highestLeftNum > highestRightNum ? highestLeftNum : highestRightNum;
    }
}