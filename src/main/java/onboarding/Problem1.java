package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (checkInput(pobiLeft, pobiRight, crongLeft, crongRight) != 1)
            return -1;

        int pobiLeftMaxNum = maxNum(addNum(pobiLeft), multiplyNum(pobiLeft));
        int pobiRightMaxNum = maxNum(addNum(pobiRight), multiplyNum(pobiRight));
        int crongLeftMaxNum = maxNum(addNum(crongLeft), multiplyNum(crongLeft));
        int crongRightMaxNum = maxNum(addNum(crongRight), multiplyNum(crongRight));
        int pobiMaxNum = maxNum(pobiLeftMaxNum, pobiRightMaxNum);
        int crongMaxNum = maxNum(crongLeftMaxNum, crongRightMaxNum);

        return getWinner(pobiMaxNum, crongMaxNum);
    }

    private static int checkInput(int pobiLeft, int pobiRight, int crongLeft, int crongRight) {

        if (pobiLeft<=1 || pobiRight >=400 || crongLeft<=1 || crongRight >=400)
            return -1;
        if (pobiLeft%2 == 0 || pobiRight%2 ==1 || crongLeft%2 == 0 || crongRight%2 ==1)
            return -1;
        if (pobiRight-pobiLeft != 1 || crongRight-crongLeft != 1)
            return -1;
        return 1;
    }

    private static int addNum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    private static int multiplyNum(int num) {
        int prod = 1;
        while (num != 0) {
            prod *= (num % 10);
            num /= 10;
        }
        return prod;
    }

    private static int maxNum(int sum, int prod) {
        if (sum >= prod) {
            return sum;
        }
        return prod;
    }

    private static int getWinner(int pobiMaxNum, int crongMaxNum) {
        if (pobiMaxNum > crongMaxNum)
            return 1;
        if (pobiMaxNum < crongMaxNum)
            return 2;
        return 0;
    }
}