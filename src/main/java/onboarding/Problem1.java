package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pLeftPage = pobi.get(0);
        int pRightPage = pobi.get(1);
        int cLeftPage = crong.get(0);
        int cRightPage = crong.get(1);
        // proxy -> check page exception
        if (checkPage(pLeftPage, pRightPage) || checkPage(cLeftPage, cRightPage)) {
            return -1;
        }
        int p_val = Math.max(Math.max(sumDigit(pLeftPage), prodDigit(pLeftPage)),
                Math.max(sumDigit(pRightPage),prodDigit(pRightPage)));
        int c_val = Math.max(Math.max(sumDigit(cLeftPage), prodDigit(cLeftPage)),
                Math.max(sumDigit(cRightPage), prodDigit(cRightPage)));
        return (p_val > c_val) ? 1 : (p_val < c_val) ? 2 : 0;
    }
    /* Check start page or last page && Check linked page a0, a1 */
    private static boolean checkPage(int leftPage, int rightPage) {
        return (leftPage == 1 || rightPage == 400 || leftPage + 1 != rightPage ||
                leftPage > 400 || rightPage < 0);
    }

    private static int sumDigit(int number) {
        int output = 0;
        while (number / 10 != 0) {
            output += number % 10;
            number /= 10;
        }
        output += number; // last digit
        return output;
    }
    private static int prodDigit(int number) {
        int output = 1;
        while (number / 10 != 0) {
            output *= number % 10;
            number /= 10;
        }
        output *= number; // last digit
        return output;
    }
}