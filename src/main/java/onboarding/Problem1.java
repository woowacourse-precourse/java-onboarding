package onboarding;

import java.util.List;

import static java.lang.Math.*;

class Problem1 {

    private static final int INIT_ERROR = -1;
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;;

    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = 0;

        int pobiLeftPage = pobi.get(0), pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0), crongRightPage = crong.get(1);

        if (checkException(pobiLeftPage, pobiRightPage) || checkException(crongLeftPage, crongRightPage)) {
            return INIT_ERROR;
        }
        if (pobi.size() != 2 || crong.size() != 2) {
            return INIT_ERROR;
        }

        int pobiMaxScore = calcMaxScore(pobiLeftPage, pobiRightPage);
        int crongMaxScore = calcMaxScore(crongLeftPage, crongRightPage);

        answer = getResult(pobiMaxScore, crongMaxScore);

        System.out.println("answer = " + answer);
        return answer;
    }

    private static int getResult(int pobiMaxScore, int crongMaxScore) {
        if (pobiMaxScore > crongMaxScore) {
            return POBI_WIN;
        }
        if (pobiMaxScore < crongMaxScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }

    private static int calcMaxScore(int leftPage, int rightPage) {
        return max(calcPage(leftPage), calcPage(rightPage));
    }

    private static int calcPage(int num) {
        char[] numArr = String.valueOf(num).toCharArray();
        int sum = 0;
        int mul = 1;

        for (int i = 0; i < numArr.length; i++) {
            sum += numArr[i] - 48;
            mul *= numArr[i] - 48;
        }

        return max(sum, mul);
    }

    private static boolean checkException(int leftPage, int rightPage) {
        if (leftPage >= rightPage) {
            return true;
        }
        if (leftPage < FIRST_PAGE || rightPage > LAST_PAGE) {
            return true;
        }
        if (rightPage - leftPage != 1) {
            return true;
        }
        return false;
    }
}