package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (pobiRightPage - pobiLeftPage != 1 || crongRightPage - crongLeftPage != 1) {
            return -1;
        }

        int pobiNum = Math.max(getMaximalNumberOption(pobiLeftPage), getMaximalNumberOption(pobiRightPage));
        int crongNum = Math.max(getMaximalNumberOption(crongLeftPage), getMaximalNumberOption(crongRightPage));

        if (pobiNum > crongNum) {
            return 1;
        } else if (pobiNum < crongNum) {
            return 2;
        }

        return 0;
    }

    private static int getMaximalNumberOption(int num) {
        int summedDigits = 0;
        int multipliedByDigits = 1;

        while (num > 0) {
            int digitValue = num % 10;
            num /= 10;
            summedDigits += digitValue;
            multipliedByDigits *= digitValue;
        }

        return Math.max(summedDigits, multipliedByDigits);
    }
}