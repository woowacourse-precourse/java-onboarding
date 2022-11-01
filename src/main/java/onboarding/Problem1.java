
package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            return -1;
        }

        if (pobi.get(0) == 1 || crong.get(0) == 1 || pobi.get(1) == 400 || crong.get(1) == 400) {
            return -1;
        }

        if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0) {
            return -1;
        }

        int pobiMax = getMaxValue(pobi);
        int crongMax = getMaxValue(crong);

        if (pobiMax > crongMax) {
            answer = 1;
        } else if (pobiMax < crongMax) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    public static int getMaxValue(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);
        int leftSum = 0;
        int leftMul = 1;
        int rightSum = 0;
        int rightMul = 1;
        int result = -1;

        while (left != 0) {
            leftSum += left % 10;
            leftMul *= left % 10;
            left /= 10;
        }


        while (right != 0) {
            rightSum += right % 10;
            rightMul *= right % 10;
            right /= 10;
        }

        left = leftSum > leftMul ? leftSum : leftMul;
        right = rightSum > rightMul ? rightSum : rightMul;

        return left > right ? left : right;
    }

}