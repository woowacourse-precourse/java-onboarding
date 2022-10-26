package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외 거르고
        if (pobi.size() !=2 || crong.size()!=2) return -1;
        if (pobi.get(1) < pobi.get(0) || crong.get(1) < crong.get(0)) return -1;
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) return -1;
        if (pobi.get(0) == 1 || crong.get(1) == 400) return -1;
        // pobi, crong 모두 왼쪽 숫자, 오른쪽 숫자 각각 곱하거나 더해서 큰수 고른다
        // 둘중 큰수
        // 둘 비교해서 값 반환.
        int pobiNum = highestNum(pobi);
        int crongNum = highestNum(crong);

        if (pobiNum > crongNum) return 1;
        if (pobiNum < crongNum) return 2;
        if (pobiNum == crongNum) return 0;
        return -1;
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