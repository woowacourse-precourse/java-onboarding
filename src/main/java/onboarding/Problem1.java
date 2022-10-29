package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);

        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (validatePageNum(pobiLeftPage, pobiRightPage) == false
                || validatePageNum(crongLeftPage, crongRightPage) == false) {
            return -1;
        }

        int pobiMaxNumber = Math.max(
                Math.max(getSumOfDigits(pobiLeftPage), getMultipleOfDigits(pobiLeftPage)),
                Math.max(getSumOfDigits(pobiRightPage), getMultipleOfDigits(pobiRightPage)));

        int crongMaxNumber = Math.max(
                Math.max(getSumOfDigits(crongLeftPage), getMultipleOfDigits(crongLeftPage)),
                Math.max(getSumOfDigits(crongRightPage), getMultipleOfDigits(crongRightPage)));

        if (pobiMaxNumber > crongMaxNumber) {
            return 1;
        } else if (pobiMaxNumber < crongMaxNumber) {
            return 2;
        } else {
            return 0;
        }
    }

    private static boolean validatePageNum(int num1, int num2) {
        if ((num1 % 2 == 0) || (num2 % 2 != 0) || (num2 - num1 != 1)) {
            return false;
        } else {
            return true;
        }
    }

    private static int getSumOfDigits(int num) {
        String str = Integer.toString(num);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - 48;
        }

        return sum;
    }

    private static int getMultipleOfDigits(int num) {
        String str = Integer.toString(num);
        int multiple = 1;
        for (int i = 0; i < str.length(); i++) {
            multiple *= str.charAt(i) - 48;
        }
        return multiple;
    }
}
