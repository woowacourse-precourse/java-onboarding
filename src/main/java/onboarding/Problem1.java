package onboarding;

import java.util.List;

import static onboarding.Calculator.*;
import static onboarding.Rule.*;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiNum, crongNum;
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (!checkInvalidInput(pobi) || !checkInvalidInput(crong))
            return -1;

        pobiNum = calculateMax(
                calculateMax(addEachDigitOfPage(pobiLeftPage), addEachDigitOfPage(pobiRightPage)),
                calculateMax(multiplyEachDigitOfPage(pobiLeftPage), multiplyEachDigitOfPage(pobiRightPage)));
        crongNum = calculateMax(
                calculateMax(addEachDigitOfPage(crongLeftPage), addEachDigitOfPage(crongRightPage)),
                calculateMax(multiplyEachDigitOfPage(crongLeftPage), multiplyEachDigitOfPage(crongRightPage)));

        return getResult(pobiNum, crongNum);
    }
}

class Calculator {
    public static int multiplyEachDigitOfPage(int num) {
        int sum = 1;

        while (num != 0) {
            sum *= num % 10;
            num /= 10;
        }

        return sum;
    }

    public static int addEachDigitOfPage(int num) {
        int sum = 0;

        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public static int calculateMax(int num1, int num2) {
        return Math.max(num1, num2);
    }
}

class Rule{

    private enum Winner {
        DRAW,
        POBI,
        CRONG
    }

    public static boolean checkInvalidInput(List<Integer> list) {
        int leftPage = list.get(0);
        int rightPage = list.get(1);

        if ((leftPage <= 0) || rightPage > 400)
            return false;

        if (rightPage - leftPage != 1)
            return false;

        if (leftPage % 2 != 1)
            return false;

        if (rightPage % 2 != 0)
            return false;

        return true;
    }

    public static int getResult(int pobiNum, int crongNum) {
        if (pobiNum == crongNum)
            return Winner.DRAW.ordinal();

        if (pobiNum > crongNum)
            return Winner.POBI.ordinal();

        if (pobiNum < crongNum)
            return Winner.CRONG.ordinal();

        return -1;
    }
}