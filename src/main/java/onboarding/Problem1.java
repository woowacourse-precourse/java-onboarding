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

        int pobiScore = findMaxScore(pobiLeftPage, pobiRightPage);
        int crongScore = findMaxScore(crongLeftPage, crongRightPage);
        answer = compareScore(pobiScore, crongScore);

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

    public static int findMaxScore(int leftPage, int rightPage) {
        if (compareMultipleNumber(leftPage, rightPage)
                - comparePlusNumber(leftPage, rightPage) >= 0) {
            return compareMultipleNumber(leftPage, rightPage);
        }
        return comparePlusNumber(leftPage, rightPage);
    }

    public static int compareScore(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) return 1;
        if (pobiScore < crongScore) return 2;
        return 0;
    }

    public static boolean isException(int leftPage, int rightPage) {
        //연속된 페이지가 아닌 경우
        if (rightPage - leftPage != 1) {
            return false;
        }

        // 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수가 아닌 경우
        if ((leftPage - 1) / 2 != 0 || rightPage / 2 != 0) {
            return false;
        }

        // 시작 면이나 마지막 면을 포함하여 페이지를 벗어난 곳 펼친 경우
        if (leftPage <= 1 || rightPage >= 400) {
            return false;
        }
        return true;
    }
}