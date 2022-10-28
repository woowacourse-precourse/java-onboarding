package onboarding;

import java.util.List;

class Problem1 {

    static private final int EXCEPTION_ANSWER = -1;
    static private final int FIRST_PAGE = 1;
    static private final int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = 0;

        int pobiLeftPage = pobi.get(0), pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0), crongRightPage = crong.get(1);

        if (checkException(pobiLeftPage, pobiRightPage) || checkException(crongLeftPage, crongRightPage)) {
            return EXCEPTION_ANSWER;
        }
        if (pobi.size() != 2 || crong.size() != 2) {
            return EXCEPTION_ANSWER;
        }

        System.out.println("answer = " + answer);
        return answer;
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