package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static int singleNumberMax(int number) {
        int sum = 0;
        int product = 1;

        if (number <= 2 || number >= 399) {
            return -1;
        }

        ArrayList<Integer> arrNum = new ArrayList<>();
        while (number > 0) {
            arrNum.add(number % 10);
            number /= 10;
        }

        for (int i = 0; i < arrNum.size(); i++) {
            sum += arrNum.get(i);
            product *= arrNum.get(i);
        }

        if (sum > product) {
            return sum;
        }
        return product;
    }

    private static int maxResult(int leftNum, int rightNum) {
        int leftMax = singleNumberMax(leftNum);
        int rightMax = singleNumberMax(rightNum);
        if (leftMax == -1 || rightMax == -1) {
            return -1;
        }

        if (leftMax > rightMax) {
            return leftMax;
        }
        return rightMax;
    }

    private static boolean isNotPage(List<Integer> arr) {
        if (arr.get(1) != arr.get(0) + 1) {
            return true;
        }
        if (arr.size() != 2) {
            return true;
        }
        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isNotPage(pobi) || isNotPage(crong)) {
            return -1;
        }

        int pobiMax = maxResult(pobi.get(0), pobi.get(1));
        int crongMax = maxResult(crong.get(0), crong.get(1));

        if (pobiMax == -1 || crongMax == -1) {
            return -1;
        }

        if (pobiMax > crongMax) {
            answer = 1;
        }
        if (pobiMax < crongMax) {
            answer = 2;
        }
        if (pobiMax == crongMax) {
            answer = 0;
        }
        return answer;
    }
}