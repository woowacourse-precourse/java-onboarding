package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pLeftPage = pobi.get(0);
        int pRightPage = pobi.get(1);
        int cLeftPage = crong.get(0);
        int cRightPage = crong.get(1);
        // proxy-> check exception
        if (inputProxy(pLeftPage, pRightPage) || inputProxy(cLeftPage, cRightPage)) {
            return -1;
        }
        int p_val = Math.max(Math.max(digitSum(pLeftPage),digitProd(pLeftPage)),Math.max(digitSum(pRightPage),digitProd(pRightPage)));
        int c_val = Math.max(Math.max(digitSum(cLeftPage),digitProd(cLeftPage)),Math.max(digitSum(cRightPage),digitProd(cRightPage)));
        return (p_val > c_val) ? 1 : (p_val < c_val) ? 2 : 0;
    }
    private static boolean inputProxy(int leftPage, int rightPage) {
        // Check start page or last page && Check linked page a0, a1
        return (leftPage == 1 || rightPage == 400 || leftPage + 1 != rightPage);
    }

    private static int digitSum(int N) {
        int output = 0;
        while (N / 10 != 0) {
            output += N % 10;
            N /= 10;
        }
        output += N; // last digit
        return output;
    }
    private static int digitProd(int N) {
        int output = 1;
        while (N / 10 != 0) {
            output *= N % 10;
            N /= 10;
        }
        output *= N; // last digit
        return output;
    }
}