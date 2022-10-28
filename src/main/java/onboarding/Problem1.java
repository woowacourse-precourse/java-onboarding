package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (!isException(pobiLeftPage, pobiRightPage)
                || !isException(crongLeftPage, crongRightPage)) {
            return -1;
        }
        return answer;
    }

    public static int plusDigits(int number) {
        int plusNumber = 0;

        while (number > 0) {
            plusNumber += number % 10;
            number /= 10;
        }
        return number;
    }

    public static int multipleDigits(int number) {
        int multipleNumber = 1;

        while (number > 0) {
            multipleNumber *= number % 10;
            number /= 10;
        }
        return number;
    }

    public static int comparePlusNumber(int leftPage, int rightPage) {
        if (plusDigits(leftPage) - plusDigits(rightPage) >= 0) {
            return plusDigits(leftPage);
        }
        return plusDigits(rightPage);
    }

    public static int compareMultipleNumber(int leftPage, int rightPage) {
        if (multipleDigits(leftPage) - multipleDigits(rightPage) >= 0) {
            return multipleDigits(leftPage);
        }
        return multipleDigits(rightPage);
    }

    public static boolean isException(int leftPage, int rightPage) {
        if (rightPage - leftPage == 1) {
            return true;
        }
        return false;
    }
}